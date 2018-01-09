package com.wishlister.usecase

import com.wishlister.entities.Item
import com.wishlister.entities.Venue
import org.junit.Test
import kotlin.test.assertTrue

class VenueUsecaseTest {
	
	@Test fun testSearchVenue(): Unit {
		val venueUsecase = VenueUsecase()
		assertTrue(venueUsecase.searchVenue().size > 0)
	}
	
	@Test fun testPhotos(): Unit {
		val venueId : String =  "4a942a25f964a520972020e3"
		val photos : List<Item> = VenueUsecase().photos(venueId)
		assertTrue(photos.size > 0)
	}
	
	fun testFindVenue(): Unit {
		val venues : List<Venue> = VenueUsecase().searchVenue()
		for(venue in venues) {
			println(VenueUsecase().findVenue(venue.id))
		}
	}
	
}

