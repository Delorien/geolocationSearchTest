package com.geolocation.search.model.helper;

import static com.geolocation.search.model.helper.PlaceCompareHelper.isSameLocation;
import static com.geolocation.search.model.helper.PlaceCompareHelper.isSameName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.springframework.data.geo.Point;

import com.geolocation.search.model.Place;

public class PlaceCompareHelperTest {

	@Test
	public void sameName_returnTrueForHeightSimilarityNames() {

		Place place1 = new Place();
		place1.setName("Padaria Santo Antonio");

		Place place2 = new Place();
		place2.setName("Padaria St. Antonio");

		assertThat(isSameName(place1, place2), is(true));
	}

	@Test
	public void sameName_returnFalseForLowSimilarityNames() {

		Place place1 = new Place();
		place1.setName("Padaria Antonio De Deus");

		Place place2 = new Place();
		place2.setName("Padaria Santo Antonio");

		assertThat(isSameName(place1, place2), is(false));
	}

	@Test
	public void sameLocation_returnTrueForSameLocation() {

		Point location = new Point(-23.5712987, -46.6464601);

		Place place1 = new Place();
		place1.setLocation(location);

		Place place2 = new Place();
		place2.setLocation(location);

		assertThat(isSameLocation(place1, place2), is(true));
	}

}
