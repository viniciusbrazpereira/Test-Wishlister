package com.wishlister.usecase

import com.wishlister.entities.Item
import com.wishlister.entities.Venue
import org.junit.Test
import kotlin.test.assertTrue

class VenueUsecaseTest {
	
	private val foursquareUsecase : FoursquareUsecase = FoursquareUsecaseImpl()
	
	@Test fun testSearchVenue(): Unit {
		assertTrue(foursquareUsecase.searchVenue().size > 0)
	}
	
	@Test fun testPhotos(): Unit {
		val venueId : String =  "4a942a25f964a520972020e3"
		val photos : List<Item> = foursquareUsecase.photos(venueId)
		assertTrue(photos.size > 0)
	}
}

