package com.geolocation.searchTest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geolocation.searchTest.model.Place;

@RestController
public class PlaceController {

	@RequestMapping(value = "/place", method = RequestMethod.POST)
	public Place add(@RequestBody Place place) {
		System.out.println(place);
		return place;
	}

}
