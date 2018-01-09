package com.wishlister.controller

import com.wishlister.usecase.FoursquareUsecase
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {
	
	@RequestMapping("/welcome")
    fun welcome() : String {
        return "welcome"
    }
	
	@RequestMapping("/foursquare/callback")
    fun callback() : String {
		FoursquareUsecase().searchVenue()
        return "venues"
    }

}


