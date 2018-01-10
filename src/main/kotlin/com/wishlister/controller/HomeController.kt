package com.wishlister.controller

import com.wishlister.usecase.FoursquareUsecase
import com.wishlister.usecase.FoursquareUsecaseImpl
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HomeController {
	
	private val foursquareUsecase : FoursquareUsecase = FoursquareUsecaseImpl()
	
	@RequestMapping("/welcome")
    fun welcome() : String {
        return "welcome"
    }
	
	@RequestMapping("/auth")
    fun authFoursquare() : String {
		 return "redirect:" + foursquareUsecase.authFoursquare()
    }
	
	@RequestMapping("/foursquare/callback")
    fun callback(@RequestParam(value = "code") code: String, model : Model) : String {
		val token = foursquareUsecase.accessToken(code)
		model.addAttribute("token", token)
        return "venues"
    }

}


