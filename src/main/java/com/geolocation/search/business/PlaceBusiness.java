package com.geolocation.search.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geolocation.search.dao.PlaceRepository;
import com.geolocation.search.model.Place;

@Component
public class PlaceBusiness {

	@Autowired
	PlaceRepository repository;

	public void add(Place place) {
		repository.save(place);
	}

	public List<Place> listAll() {
		return repository.findAll();		
	}

}
