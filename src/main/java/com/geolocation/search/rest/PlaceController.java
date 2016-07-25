package com.geolocation.search.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/places", method = RequestMethod.POST)
	public APIMessage add(@RequestBody List<Place> places) {
		return business.add(places);
	}

	@RequestMapping(value = "/place", method = RequestMethod.PUT)
	public APIMessage update(@RequestParam(value = "name") String name, @RequestBody Place place) {
		return business.update(name, place);
	}

	@RequestMapping(value = "/place", method = RequestMethod.GET)
	public Place get(@RequestParam(value = "name") String name) {
		return business.get(name);
	}

	@RequestMapping(value = "/places", method = RequestMethod.GET)
	public List<Place> listAll() {
		List<Place> places = business.listAll();
		return places;
	}
}
