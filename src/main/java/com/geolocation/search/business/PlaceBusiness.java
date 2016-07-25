package com.geolocation.search.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
			return new APIMessage(Status.DECLINED, "Could not find the coordinates to the address provided.",
					place.getLocalization().getAddress());
		}

		repository.save(place);
		return new APIMessage(Status.SUCCESS, "Place registered successfully.", place);
	}

	public APIMessage add(List<Place> places) {

		for (Place place : places) {
			try {
				place.getLocalization().setCoordinates(geoApiHelper.getLatLong(place.getLocalization().getAddress()));
			} catch (Exception e) {
				return new APIMessage(Status.DECLINED, "Could not find the coordinates to the address provided.",
						place.getLocalization().getAddress());
			}
			repository.save(place);
		}

		return new APIMessage(Status.SUCCESS, "Places registered successfully.", places);
	}

	public APIMessage update(String name, Place updatePlace) {

		Place place = repository.findByName(name);

		if (!StringUtils.isEmpty(updatePlace.getLocalization().getAddress())) {
			place.getLocalization().setAddress(updatePlace.getLocalization().getAddress());
			try {
				place.getLocalization().setCoordinates(geoApiHelper.getLatLong(place.getLocalization().getAddress()));
			} catch (Exception e) {
				return new APIMessage(Status.DECLINED, "Could not find the coordinates to the address provided.",
						place.getLocalization().getAddress());
			}
		}

		if (!StringUtils.isEmpty(updatePlace.getLocalization().getCity())) {
			place.getLocalization().setCity(updatePlace.getLocalization().getCity());
		}

		repository.save(place);
		return new APIMessage(Status.SUCCESS, "Places updated successfully.", place);
	}

	public Place get(String name) {
		return repository.findByName(name);
	}

	public List<Place> listAll() {
		return repository.findAll();
	}

}
