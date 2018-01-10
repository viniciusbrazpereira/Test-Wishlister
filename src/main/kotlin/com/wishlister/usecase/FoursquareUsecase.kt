package com.wishlister.usecase

import com.wishlister.entities.Venue
import com.wishlister.entities.Item

public interface FoursquareUsecase {
	
	fun authFoursquare()
	
	fun searchVenue() : List<Venue>
	
	fun photos(venueId : String) : List<Item>
}

