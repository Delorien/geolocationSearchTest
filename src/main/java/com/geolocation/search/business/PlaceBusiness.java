package com.geolocation.search.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geolocation.search.dao.PlaceRepository;
import com.geolocation.search.model.Place;
import com.geolocation.search.rest.APIMessage;
import com.geolocation.search.rest.APIMessage.Status;
import com.geolocation.search.util.GeoApiHelper;

@Component
public class PlaceBusiness {

	@Autowired
	PlaceRepository repository;

	@Autowired
	GeoApiHelper geoApiHelper;

	public APIMessage add(Place place) {

		try {
			place.getLocalization().setCoordinates(geoApiHelper.getLatLong(place.getLocalization().getAddress()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		repository.save(place);
		return new APIMessage(Status.SUCCESS, "Place registered successfully", place);
	}

	public List<Place> listAll() {
		return repository.findAll();
	}
}
