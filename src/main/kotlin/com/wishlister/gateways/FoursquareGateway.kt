package com.wishlister.gateways

import com.wishlister.entities.SearchVenuesResponse
import com.wishlister.entities.VenueDetailsResponse
import com.wishlister.entities.PhotosDetailsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

public interface FoursquareGateway {
	
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

