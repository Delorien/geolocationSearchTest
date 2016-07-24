package com.geolocation.search.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geolocation.search.dao.PlaceRepository;
import com.geolocation.search.model.Place;
import com.geolocation.search.util.GeoApiHelper;

@Component
public class PlaceBusiness {

	@Autowired
	PlaceRepository repository;

	@Autowired
	GeoApiHelper geoApiHelper;

	public void add(Place place) {

		String latLong = null;

		try {
			latLong = geoApiHelper.getLatLong(place.getLocalization().getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(latLong);

		repository.save(place);
	}

	public List<Place> listAll() {
		return repository.findAll();
	}

}
