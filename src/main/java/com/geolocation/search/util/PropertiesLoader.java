package com.geolocation.search.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
	private static final Properties PROPERTIES = loadResource("geolocation_search.properties");

	public static String get(String key) {
		return PROPERTIES.getProperty(key);
	}

	private static Properties loadResource(String resorceFileName) {
		final Properties properties = new Properties();

		try {
			final InputStream stream = PropertiesLoader.class.getClassLoader().getResourceAsStream(resorceFileName);
			if (stream != null) {
				properties.load(stream);
				stream.close();
			}
		} catch (IOException e) {
			throw new RuntimeException("The geolocation_search properties file can not be opened: " + resorceFileName);
		}

		return properties;
	}

}
