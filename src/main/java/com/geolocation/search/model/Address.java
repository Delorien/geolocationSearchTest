package com.geolocation.search.model;

import com.geolocation.search.model.helper.AddressCompareHelper;

public class Address {

	private String address;
	private String city;

	public Address() {
	}

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

	public boolean isSameAddress(Address toCompare) {
		return AddressCompareHelper.isSameAddress(this, toCompare);
	}
	
}