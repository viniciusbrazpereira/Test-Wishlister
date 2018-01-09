package com.wishlister.controller

import com.wishlister.usecase.VenueUsecase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HomeController {
	
	@RequestMapping("/welcome")
    fun welcome() : String {
        return "welcome"
    }
	
	@RequestMapping("/foursquare/callback")
    fun callback() : String {
		val venueUsecase = VenueUsecase()
		venueUsecase.searchVenue()
        return "venues"
    }

}


