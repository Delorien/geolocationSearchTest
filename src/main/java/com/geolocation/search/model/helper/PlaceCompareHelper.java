package com.geolocation.search.model.helper;

import com.geolocation.search.model.Place;
import com.geolocation.search.util.PropertiesLoader;

import info.debatty.java.stringsimilarity.JaroWinkler;

public class PlaceCompareHelper {

	private static final double JARO_WINKLER_SIMILARITY_THRESHOLD = Double
			.parseDouble(PropertiesLoader.get("jaro.winkler.similarity.threshold"));

	private static JaroWinkler jaroWinkler = new JaroWinkler();;

	public static boolean isSameName(Place place1, Place place2) {
		if (jaroWinkler.similarity(place1.getName(), place2.getName()) > JARO_WINKLER_SIMILARITY_THRESHOLD) {
			return true;
		}
		return false;
	}

	public static boolean isSameLocation(Place place, Place toCompare) {
		return place.getLocation().equals(toCompare.getLocation());
	}

}
