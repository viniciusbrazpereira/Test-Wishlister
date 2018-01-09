package com.wishlister.usecase

import org.junit.Test
import kotlin.test.assertNotNull
import com.wishlister.entities.Venue

class VenueUsecaseTest {
	
	@Test fun testSearchVenue(): Unit {
		val venueUsecase = VenueUsecase()
		assertNotNull(venueUsecase.searchVenue())
	}
	
	fun testFindVenue(): Unit {
		val venues : List<Venue> = VenueUsecase().searchVenue()
		for(venue in venues) {
			println(VenueUsecase().findVenue(venue.id))
		}
	}
	
}

fun main (args : Array<String>) {
	val venues : List<Venue> = VenueUsecase().searchVenue()
		for(venue in venues) {
			println(VenueUsecase().findVenue(venue.id))
		}
}
