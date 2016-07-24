package com.geolocation.search.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

@Component
public class GeoApiHelper {

	GeoApiContext context;

	@PostConstruct
	public void postConstructor() {
		String apiKey = PropertiesLoader.get("google.api.geolocation.key");
		context = new GeoApiContext().setApiKey(apiKey);
	}

	public Double[] getLatLong(String address) throws Exception {
		GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
		LatLng location = results[0].geometry.location;
		return new Double[] { location.lat, location.lng };
	}
}
