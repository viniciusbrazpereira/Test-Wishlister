package com.wishlister.usecase

import com.wishlister.entities.Venue
import com.wishlister.entities.Item

public interface FoursquareUsecase {
	
	fun authFoursquare() : String
	
	fun accessToken(code : String) : String
	
	fun searchVenue() : List<Venue>
	
	fun photos(venueId : String) : List<Item>
}

