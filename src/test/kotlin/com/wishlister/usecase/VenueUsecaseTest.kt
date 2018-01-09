package com.wishlister.usecase

import org.junit.Test
import kotlin.test.assertNotNull

class VenueUsecaseTest {
	
	@Test fun testAssert(): Unit {
		val venueUsecase = VenueUsecase()
		assertNotNull(venueUsecase.searchVenue())
	}
	
}

