package com.jq.mob.domain;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.jq.mob.domain.CountrySummaryWrapper.CountrySummary;

public class CountryWrapper {

	@XmlRootElement(name = "country")
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Country extends CountrySummary {
		List<Embassy> embassies = Collections.emptyList();

		public List<Embassy> getEmbassies() {
			return embassies;
		}

		public void setEmbassies(List<Embassy> embassies) {
			this.embassies = embassies;
		}

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Embassy {
		public static class Address {
			private String markup;

			public String getMarkup() {
				return markup;
			}

			public void setMarkup(String markup) {
				this.markup = markup;
			}

			public String getPlain() {
				return plain;
			}

			public void setPlain(String plain) {
				this.plain = plain;
			}

			private String plain;
		}

		public static class OfficeHours {
			private String markup;

			public String getMarkup() {
				return markup;
			}

			public void setMarkup(String markup) {
				this.markup = markup;
			}

			public String getPlain() {
				return plain;
			}

			public void setPlain(String plain) {
				this.plain = plain;
			}

			private String plain;
		}

		private String locationName, designation, originalUrl, phone, url,
				email, fcoId, lng, lat;
		private Date createdAt, publishedOn, updatedAt;
		private Address address;
		private OfficeHours officeHours;

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		@JsonProperty(value = "office_hours")
		public OfficeHours getOfficeHours() {
			return officeHours;
		}

		public void setOfficeHours(OfficeHours officeHours) {
			this.officeHours = officeHours;
		}

		@JsonProperty(value = "original_url")
		public String getOriginalUrl() {
			return originalUrl;
		}

		public void setOriginalUrl(String originalUrl) {
			this.originalUrl = originalUrl;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@JsonProperty(value = "fco_id")
		public String getFcoId() {
			return fcoId;
		}

		public void setFcoId(String fcoId) {
			this.fcoId = fcoId;
		}

		@JsonProperty(value = "long")
		public String getLng() {
			return lng;
		}

		public void setLng(String lng) {
			this.lng = lng;
		}

		public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}

		@JsonProperty(value = "published_on")
		public Date getPublishedOn() {
			return publishedOn;
		}

		public void setPublishedOn(Date publishedOn) {
			this.publishedOn = publishedOn;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		@JsonProperty(value = "location_name")
		public String getLocationName() {
			return locationName;
		}

		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		@JsonProperty(value = "created_at")
		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

	}

	private Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
