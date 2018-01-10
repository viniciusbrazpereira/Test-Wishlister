package com.wishlister.gateways

import com.wishlister.entities.AccessTokenResponse
import com.wishlister.entities.PhotosDetailsResponse
import com.wishlister.entities.SearchVenuesResponse
import com.wishlister.entities.VenueDetailsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

public interface FoursquareGateway {
	
	@GET("/oauth2/authenticate")
	fun authFoursquare(	@Query("client_id") client_id: String,
						@Query("response_type") response_type: String,
						@Query("redirect_uri") redirect_uri: String) : Call<ResponseBody>
	
	@GET("/oauth2/access_token")
	fun accessToken(	@Query("client_id") client_id: String,
					@Query("client_secret") client_secret: String,
					@Query("grant_type") grant_type: String,
					@Query("redirect_uri") redirect_uri: String,
					@Query(value = "code", encoded = true) code: String) : Call<AccessTokenResponse>
	
	@GET("/v2/venues/search")
	fun searchVenue(	@Query("client_id") client_id: String,
					@Query("client_secret") client_secret: String,
					@Query("v") version: String,
               		@Query("ll") location: String) : Call<SearchVenuesResponse>
	
	@GET("/v2/venues/{VENUE_ID}")
	fun findVenue(	@Query("client_id") client_id: String,
					@Query("client_secret") client_secret: String,
					@Query("v") version: String,
					@Path("VENUE_ID") venue_id: String) : Call<VenueDetailsResponse>
	
	@GET("/v2/venues/{VENUE_ID}/photos")
	fun photos(	@Path("VENUE_ID") venue_id: String,
			   	@Query("client_id") client_id: String,
			   	@Query("client_secret") client_secret: String,
			   	@Query("v") version: String) : Call<PhotosDetailsResponse>
}


