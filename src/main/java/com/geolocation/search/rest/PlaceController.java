package com.geolocation.search.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geolocation.search.business.PlaceBusiness;
import com.geolocation.search.model.Place;

@RestController
public class PlaceController {

	@Autowired
	PlaceBusiness business;

	@RequestMapping(value = "/place", method = RequestMethod.POST)
	public APIMessage add(@RequestBody Place place) {
		return business.add(place);
	}

	@RequestMapping(value = "/places", method = RequestMethod.GET)
	public List<Place> listAll() {
		List<Place> places = business.listAll();
		return places;
	}

}
