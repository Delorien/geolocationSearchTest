package com.geolocation.search.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.geolocation.search.model.helper.PlaceCompareHelper;

@Document(collection = "places")
public class Place {

	@Id
	private String id;

	private String name;
	private Address address;

	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private Point location;

	public Place() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public boolean isSameName(Place toCompare) {
		return PlaceCompareHelper.isSameName(this, toCompare);
	}

	public boolean isSameLocation(Place toCompare) {
		return PlaceCompareHelper.isSameLocation(this, toCompare);
	}
	
	public boolean isSame(Place toCompare) {
		if (isSameName(toCompare) || this.address.isSameAddress(toCompare.getAddress()) || isSameLocation(toCompare)) {
			return true;
		}
		return false;
	}

}
