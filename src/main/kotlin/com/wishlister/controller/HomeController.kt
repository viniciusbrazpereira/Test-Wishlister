package com.wishlister.controller

import com.wishlister.gateways.FoursquareGateway
import com.wishlister.entities.SearchVenuesResponse
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Controller
class HomeController {
	
	private var baseUrl : String = "https://api.foursquare.com/"
	private val client_id: String = "OJRCA0HT2UMLW4TJ4RER42OACUXITZ4VDMTUHXINVC5SYL1T"
	private val client_secret: String = "UT1QIQK2PEWTRZNFWZNEJNBMNFOZZFXGUEZUJ5HD5VX3D2QF"
	private val v: String = "20170801"
	private val ll: String = "40.7243,-74.0018"
	
	@RequestMapping("/welcome")
    fun greeting(@RequestParam(value = "message", defaultValue = "HelloWorld!") message: String, model : Model) : String {
        model.addAttribute("message", message)
        return "welcome"
    }
	
	@RequestMapping("/foursquare/callback")
    fun callback(model : Model) : String {
		val retrofit = Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build()

		val foursquareGateway: FoursquareGateway = retrofit.create(FoursquareGateway::class.java)
		
		val callResponse = foursquareGateway.searchVenue(client_id, client_secret, v, ll)
		val response = callResponse.execute()
		
		if (response.isSuccessful) {
			response?.let {
			    val searchVenuesResponse : SearchVenuesResponse? = it.body()
				model.addAttribute("message", searchVenuesResponse?.response?.venues)
			}
		}
		
        return "venues"
    }

}


