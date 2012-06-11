package com.jq.mob.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

public class CountrySummaryWrapper {

	@XmlRootElement(name = "countrySummary")
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class CountrySummary {
		private String name;
		private String slug;
		private String flagUrl;

		public String getName() {
			return name;
		}

		public String getSlug() {
			return slug;
		}

		public void setSlug(String slug) {
			this.slug = slug;
		}

		@JsonProperty(value = "flag_url")
		public String getFlagUrl() {
			return flagUrl;
		}

		public void setFlagUrl(String flagUrl) {
			this.flagUrl = flagUrl;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	private CountrySummary countrySummary;

	@JsonProperty(value = "country")
	public CountrySummary getCountrySummary() {
		return countrySummary;
	}

	public void setCountrySummary(CountrySummary countrySummary) {
		this.countrySummary = countrySummary;
	}

}
