package com.wishlister.usecase

import com.wishlister.entities.SearchVenuesResponse
import com.wishlister.entities.Venue
import com.wishlister.entities.Category
import com.wishlister.gateways.FoursquareGateway
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VenueUsecase {
	
	private var baseUrl : String = "https://api.foursquare.com/"
	private val client_id: String = "OJRCA0HT2UMLW4TJ4RER42OACUXITZ4VDMTUHXINVC5SYL1T"
	private val client_secret: String = "UT1QIQK2PEWTRZNFWZNEJNBMNFOZZFXGUEZUJ5HD5VX3D2QF"
	private val v: String = "20170801"
	private val ll: String = "40.7243,-74.0018"
	
	fun searchVenue() : List<Venue> {
		val retrofit = Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build()

		val foursquareGateway: FoursquareGateway = retrofit.create(FoursquareGateway::class.java)
		
		val callResponse = foursquareGateway.searchVenue(client_id, client_secret, v, ll)
		val response = callResponse.execute()
		
		val listVenue : List<Venue> = mutableListOf<Venue>()
		
		if (response.isSuccessful) {
			response?.let {
			    val searchVenuesResponse : SearchVenuesResponse = it.body()
				for(venue in searchVenuesResponse.response.venues) {
					listVenue.plus(venue)
				}
				
			}
		}
		
        return listVenue
    }
	
}

