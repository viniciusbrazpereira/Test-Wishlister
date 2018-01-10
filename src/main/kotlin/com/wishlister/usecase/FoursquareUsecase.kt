package com.wishlister.usecase

import com.wishlister.entities.Venue
import com.wishlister.entities.Item

public interface FoursquareUsecase {
	
	fun searchVenue() : List<Venue>
	
	fun photos(venueId : String) : List<Item>
}

