package com.geolocation.search.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/places", method = RequestMethod.POST)
	public APIMessage add(@RequestBody List<Place> places) {
		return business.add(places);
	}

	@RequestMapping(value = "/place/{id}", method = RequestMethod.PUT)
	public APIMessage update(@PathVariable("id") String id, @RequestBody Place place) {
		return business.update(id, place);
	}

	@RequestMapping(value = "/place/{id}", method = RequestMethod.GET)
	public Place get(@PathVariable("id") String id) {
		return business.get(id);
	}

	@RequestMapping(value = "/places", method = RequestMethod.GET)
	public List<Place> listAll() {
		return business.listAll();
	}

	@RequestMapping(value = "/places/{id}/radius/{radius}", method = RequestMethod.GET)
	public List<Place> listByLocationNear(@PathVariable("id") String id, @PathVariable("radius") Double radius) {
		return business.listByLocationNear(id, radius);
	}
}
