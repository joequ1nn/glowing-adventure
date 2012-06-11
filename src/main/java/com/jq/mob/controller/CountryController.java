package com.jq.mob.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jq.mob.domain.CountrySummaryWrapper.CountrySummary;
import com.jq.mob.domain.CountryWrapper.Country;
import com.jq.mob.service.TravelAdviceService;

@Controller
public class CountryController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	@Qualifier(value = "fco")
	private TravelAdviceService travelAdviceService;

	/**
	 * @param travelAdviceService
	 *            the travelAdviceService to set
	 */
	public void setTravelAdviceService(TravelAdviceService travelAdviceService) {
		this.travelAdviceService = travelAdviceService;
	}

	@RequestMapping(value = "/countries.htm", method = RequestMethod.GET)
	public ModelAndView getCountryList(SitePreference pref) throws Exception {

		ModelAndView mav = new ModelAndView("countries/list");
		if (pref.isMobile()) {
			log.trace("SitePreference is Mobile");
			mav = new ModelAndView("countries/list-mobile");
		}
		List<CountrySummary> countries = this.travelAdviceService
				.getCountries();
		mav.addObject("countries", countries);
		return mav;
	}

	@RequestMapping(value = "/countries/{name}.htm", method = RequestMethod.GET)
	public ModelAndView getCountry(@PathVariable String name,
			SitePreference pref) throws Exception {
		ModelAndView mav = new ModelAndView("countries/show");
		if (pref.isMobile()) {
			log.trace("SitePreference is Mobile");
			mav = new ModelAndView("countries/show-mobile");
		}
		mav.addObject("country", this.travelAdviceService.getCountry(name));
		return mav;
	}

	@RequestMapping(value = "/countries/{name}.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Country getCountryJson(@PathVariable String name) throws Exception {
		return this.travelAdviceService.getCountry(name);
	}

	@RequestMapping(value = "/countries/{name}.xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody
	Country getCountryXml(@PathVariable String name) throws Exception {
		return this.travelAdviceService.getCountry(name);
	}

	@RequestMapping(value = "/countries.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	List<CountrySummary> getCountryListJson() throws Exception {
		return this.travelAdviceService.getCountries();
	}

	@RequestMapping(value = "/countries.xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody
	CountrySummaryList getCountryListXml() throws Exception {
		CountrySummaryList list = new CountrySummaryList();
		list.setCountrySummaries(this.travelAdviceService.getCountries());
		return list;
	}

	@XmlRootElement(name = "countrySummaryList")
	public static class CountrySummaryList {
		private List<CountrySummary> countrySummaries = new ArrayList<CountrySummary>();

		public List<CountrySummary> getCountrySummaries() {
			return countrySummaries;
		}

		public void setCountrySummaries(List<CountrySummary> countrySummaries) {
			this.countrySummaries = countrySummaries;
		}

	}
}
