package com.wishlister.usecase

import com.wishlister.entities.AccessTokenResponse
import com.wishlister.entities.Item
import com.wishlister.entities.PhotosDetailsResponse
import com.wishlister.entities.SearchVenuesResponse
import com.wishlister.entities.Venue
import com.wishlister.entities.VenueDetailsResponse
import com.wishlister.entities.VenueResponse
import com.wishlister.gateways.FoursquareGateway
import okhttp3.HttpUrl
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FoursquareUsecaseImpl : FoursquareUsecase {
	
	companion object {
		val baseUrl : String = "https://api.foursquare.com/"
		val baseUrlAuth : String = "https://foursquare.com/"
		
		val client_id: String = "OJRCA0HT2UMLW4TJ4RER42OACUXITZ4VDMTUHXINVC5SYL1T"
		val client_secret: String = "UT1QIQK2PEWTRZNFWZNEJNBMNFOZZFXGUEZUJ5HD5VX3D2QF"
		val v: String = "20170801"
		val ll: String = "40.7243,-74.0018"
		
		val code: String = "code"
		val grant_type: String = "authorization_code"
		
		val redirect_uri : String = "https://test-wishlister.herokuapp.com/foursquare/callback"
	}
	
	private fun getRetrofit(url : String) : Retrofit {
		val retrofit = Retrofit.Builder()
				.baseUrl(url)
				.addConverterFactory(GsonConverterFactory.create())
				.build()
		
		return retrofit
	}
	
	private fun getFoursquareGateway(url : String) : FoursquareGateway {
		val foursquareGateway: FoursquareGateway = getRetrofit(url).create(FoursquareGateway::class.java)
		return foursquareGateway
	}
	
	override fun authFoursquare() : String{
		val callResponse : Call<ResponseBody> = getFoursquareGateway(baseUrlAuth)
				.authFoursquare(client_id, code, redirect_uri)
		
		val response = callResponse.execute()
		
		val url : String = ""
		if (response.isSuccessful) {
			val urlRedirect : HttpUrl = response.raw().request().url()
			return urlRedirect.toString()
		}
		
		return url
	}
	
	override fun accessToken(code : String) : String{
		val callResponse : Call<AccessTokenResponse> = getFoursquareGateway(baseUrlAuth)
				.accessToken(client_id, client_secret, grant_type, redirect_uri, code)
		
		val response = callResponse.execute()
		
		val token : String = ""
		if (response.isSuccessful) {
			return response?.body()!!.access_token
		}
		
		return token
	}
	
	override fun searchVenue() : List<Venue> {
		val callResponse = getFoursquareGateway(baseUrl).searchVenue(client_id, client_secret, v, ll)
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
	
	override fun photos(venueId : String) : List<Item> {
		val callResponse = getFoursquareGateway(baseUrl).photos(venueId, client_id, client_secret, v)
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

