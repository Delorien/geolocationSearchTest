package com.geolocation.search.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.stereotype.Component;

import com.geolocation.search.dao.PlaceRepository;
import com.geolocation.search.model.Place;

@Component
public class PlaceValidator {

	private static final Distance RADIUS_SIMILARITY_THRESHOLD = new Distance(1, Metrics.KILOMETERS);

	@Autowired
	private PlaceRepository repository;

	public void validateAdd(Place place) {
		List<Place> places = repository.findByLocationNear(place.getLocation(), RADIUS_SIMILARITY_THRESHOLD);

		places.stream().filter(place::isSame).findAny().ifPresent(p -> {
			throw new IllegalArgumentException("Place registered already: " + p.getId());
		});
	}

}
