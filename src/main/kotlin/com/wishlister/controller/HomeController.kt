package com.wishlister.controller

import com.wishlister.usecase.FoursquareUsecase
import com.wishlister.usecase.FoursquareUsecaseImpl
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {
	
	private val foursquareUsecase : FoursquareUsecase = FoursquareUsecaseImpl()
	
	@RequestMapping("/welcome")
    fun welcome() : String {
        return "welcome"
    }
	
	@RequestMapping("/foursquare/callback")
    fun callback() : String {
		foursquareUsecase.searchVenue()
        return "venues"
    }

}


