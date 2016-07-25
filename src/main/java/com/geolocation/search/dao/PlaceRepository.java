package com.geolocation.search.dao;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.geolocation.search.model.Place;

public interface PlaceRepository extends MongoRepository<Place, String> {

	List<Place> findByLocationNear(Point point, Distance maxDistance);

}
