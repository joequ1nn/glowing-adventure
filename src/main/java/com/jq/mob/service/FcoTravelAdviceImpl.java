package com.jq.mob.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;
import com.jq.mob.domain.CountrySummaryWrapper;
import com.jq.mob.domain.CountrySummaryWrapper.CountrySummary;
import com.jq.mob.domain.CountryWrapper;
import com.jq.mob.domain.CountryWrapper.Country;

@Service(value = "fco")
public class FcoTravelAdviceImpl implements TravelAdviceService {

	ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

	@Override
	@Cacheable(cacheName = "getCountries")
	public List<CountrySummary> getCountries() throws Exception {
		CountrySummaryWrapper[] countries = mapper.readValue(new URL(
				"http://fco.innovate.direct.gov.uk/countries.json"),
				CountrySummaryWrapper[].class);
		ArrayList<CountrySummary> summaries = new ArrayList<CountrySummary>();
		for (CountrySummaryWrapper wrapper : countries) {
			summaries.add(wrapper.getCountrySummary());
		}
		return summaries;
	}

	@Override
	public Country getCountry(String name) throws Exception {

		CountryWrapper wrapper = mapper.readValue(
				new URL("http://fco.innovate.direct.gov.uk/countries/" + name
						+ ".json"), CountryWrapper.class);

		return wrapper.getCountry();
	}

}
