package com.geolocation.search.model.helper;

import com.geolocation.search.model.Address;
import com.geolocation.search.util.PropertiesLoader;

import info.debatty.java.stringsimilarity.JaroWinkler;

public class AddressCompareHelper {

	private static final double JARO_WINKLER_ADDRESS_SIMILARITY_THRESHOLD = Double
			.parseDouble(PropertiesLoader.get("jaro.winkler.address.similarity.threshold"));

	private static JaroWinkler jaroWinkler = new JaroWinkler();;

	public static boolean isSameAddress(Address address, Address address2) {
		if (jaroWinkler.similarity(address.getAddress(),
				address2.getAddress()) > JARO_WINKLER_ADDRESS_SIMILARITY_THRESHOLD) {
			return true;
		}
		return false;
	}

}
