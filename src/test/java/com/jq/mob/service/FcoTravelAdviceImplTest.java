package com.jq.mob.service;

import java.util.List;

import org.junit.Test;

import com.jq.mob.domain.CountrySummaryWrapper.CountrySummary;
import com.jq.mob.domain.CountryWrapper.Country;
import com.jq.mob.domain.CountryWrapper.Embassy;

public class FcoTravelAdviceImplTest {
	FcoTravelAdviceImpl svc = new FcoTravelAdviceImpl();

	@Test
	public void testGetCountries() {
		try {
			List<CountrySummary> summaries = svc.getCountries();
			for (CountrySummary country : summaries) {
				System.out.println(country.getName() + "/" + country.getSlug());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCountry() {

		try {
			Country country = svc.getCountry("afghanistan");
			System.out.println(">>" + country.getName());
			for (Embassy embassy : country.getEmbassies()) {
				System.out.println(">>>> " + embassy.getDesignation()
						+ " is in " + embassy.getLocationName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
