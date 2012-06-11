package com.jq.mob.service;

import java.util.List;

import com.jq.mob.domain.CountrySummaryWrapper.CountrySummary;
import com.jq.mob.domain.CountryWrapper.Country;

public interface TravelAdviceService {
	Country getCountry(String name) throws Exception;

	List<CountrySummary> getCountries() throws Exception;
}
