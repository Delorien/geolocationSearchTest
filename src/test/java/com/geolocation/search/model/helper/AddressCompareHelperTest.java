package com.geolocation.search.model.helper;

import static com.geolocation.search.model.helper.AddressCompareHelper.isSameAddress;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.geolocation.search.model.Address;

public class AddressCompareHelperTest {

	@Test
	public void sameAddress_returnTrueForHeightSimilarityAddress() {

		Address address1 = new Address();
		address1.setAddress("Avenida Brigadeiro Faria Lima 30");

		Address address2 = new Address();
		address2.setAddress("Av. Brig. Faria Lima 30");

		assertThat(isSameAddress(address1, address2), is(true));
	}

	@Test
	public void sameAddress_returnFalseForLowSimilarityAddress() {

		Address address1 = new Address();
		address1.setAddress("Avenida Brigadeiro Faria Lima 30");

		Address address2 = new Address();
		address2.setAddress("Av. Brigadeiro Luís Antônio 30");

		assertThat(AddressCompareHelper.isSameAddress(address1, address2), is(false));
	}

}
