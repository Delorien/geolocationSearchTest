package com.geolocation.search.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.geolocation.search.model.Place;

public interface PlaceRepository extends MongoRepository<Place, String> {
	
}
