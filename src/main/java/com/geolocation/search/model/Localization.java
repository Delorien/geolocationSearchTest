package com.geolocation.search.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Localization {

	private String address;
	private String city;
	private Double[] coordinates;
	@JsonIgnore
	private String type = "Point";

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Double[] coordinates) {
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}