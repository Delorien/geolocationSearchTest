package com.geolocation.search.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.geolocation.search.dao.PlaceRepository;
import com.geolocation.search.model.Place;
import com.geolocation.search.rest.APIMessage;
import com.geolocation.search.rest.APIMessage.Status;
import com.geolocation.search.util.GeoApiHelper;
import com.geolocation.search.validator.PlaceValidator;

@Component
public class PlaceBusiness {

	@Autowired
	PlaceRepository repository;

	@Autowired
	GeoApiHelper geoApiHelper;

	@Autowired
	PlaceValidator validator;

	public APIMessage add(Place place) {

		place.setLocation(fillCoordinates(place));

		validator.validateAdd(place);
		repository.save(place);
		return new APIMessage(Status.SUCCESS, "Place registered successfully.", place);
	}

	public APIMessage add(List<Place> places) {

		for (Place place : places) {
			place.setLocation(fillCoordinates(place));
			repository.save(place);
		}

		return new APIMessage(Status.SUCCESS, "Places registered successfully.", places);
	}

	public APIMessage update(String id, Place updatePlace) {

		Place place = repository.findOne(id);

		if (!StringUtils.isEmpty(updatePlace.getAddress().getAddress())) {
			place.getAddress().setAddress(updatePlace.getAddress().getAddress());
			place.setLocation(fillCoordinates(place));
		}

		if (!StringUtils.isEmpty(updatePlace.getAddress().getCity())) {
			place.getAddress().setCity(updatePlace.getAddress().getCity());
		}

		repository.save(place);
		return new APIMessage(Status.SUCCESS, "Places updated successfully.", place);
	}

	public Place get(String id) {
		return repository.findOne(id);
	}

	public List<Place> listAll() {
		return repository.findAll();
	}

	public List<Place> listByLocationNear(String id, Double radius) {
		Place origin = repository.findOne(id);
		if (origin == null) {
			throw new IllegalArgumentException("Could not find any place to the id provided: " + id);
		}

		return repository.findByLocationNear(origin.getLocation(), new Distance(radius, Metrics.KILOMETERS));
	}

	private Point fillCoordinates(Place place) {
		Point coordinates;
		try {
			Double[] latLong = geoApiHelper.getLatLong(place.getAddress().getAddress());
			coordinates = new Point(latLong[0], latLong[1]);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Could not find the coordinates to the address provided: " + place.getAddress().getAddress());
		}
		return coordinates;
	}

}
