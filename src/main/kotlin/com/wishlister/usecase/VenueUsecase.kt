package com.wishlister.usecase

import com.wishlister.entities.SearchVenuesResponse
import com.wishlister.entities.VenueDetailsResponse
import com.wishlister.entities.VenueResponse
import com.wishlister.entities.Venue
import com.wishlister.entities.Item
import com.wishlister.entities.PhotosDetailsResponse
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
	
	private fun getRetrofit() : Retrofit {
		val retrofit = Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build()
		
		return retrofit
	}
	
	private fun getFoursquareGateway() : FoursquareGateway {
		val foursquareGateway: FoursquareGateway = getRetrofit().create(FoursquareGateway::class.java)
		return foursquareGateway
	}
	
	fun searchVenue() : List<Venue> {
		val callResponse = getFoursquareGateway().searchVenue(client_id, client_secret, v, ll)
		val response = callResponse.execute()
		
		val listVenue : MutableList<Venue>? = mutableListOf<Venue>()
		
		if (response.isSuccessful) {
			val searchVenuesResponse : SearchVenuesResponse? = response.body()
				for(venue in searchVenuesResponse!!.response.venues) {
					listVenue!!.add(venue)
				}
		}
		
        return listVenue!!.toList()
    }
	
	fun photos(venueId : String) : List<Item> {
		val callResponse = getFoursquareGateway().photos(venueId, client_id, client_secret, v)
		val response = callResponse.execute()
		
		val list : MutableList<Item>? = mutableListOf<Item>()
		
		if (response.isSuccessful) {
			val photosDetailsResponse : PhotosDetailsResponse? = response.body()
				for(photo in photosDetailsResponse!!.response.photos.items) {
					list!!.add(photo)
				}
		}
		
        return list!!.toList()
    }
	
	fun findVenue(venueId : String) : Venue {
		val retrofit = Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build()

		val foursquareGateway: FoursquareGateway = retrofit.create(FoursquareGateway::class.java)
		
		val callResponse = foursquareGateway.findVenue(venueId, client_id, client_secret, v)
		val response = callResponse.execute()
		
		val venue : Venue = Venue()
		
		if (response.isSuccessful) {
			val venueDetailsResponse : VenueDetailsResponse? = response.body()
			val venueResponse : VenueResponse =  venueDetailsResponse!!.response
			return venueResponse.venue
		} 
		
        return venue
    }
	
}
