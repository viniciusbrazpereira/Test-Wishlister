package com.wishlister.gateway

import com.wishlister.gateways.FoursquareGateway
import com.wishlister.usecase.FoursquareUsecaseImpl
import okhttp3.ResponseBody
import org.junit.Test
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.wishlister.entities.AccessTokenResponse
import com.wishlister.entities.SearchVenuesResponse
import com.wishlister.entities.PhotosDetailsResponse
import kotlin.test.assertEquals

class FoursquareGatewayTest {
	
	private fun getRetrofit() : Retrofit {
		val retrofit = Retrofit.Builder()
				.baseUrl(FoursquareUsecaseImpl.baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build()
		
		return retrofit
	}
	
	private fun getRetrofitAuth() : Retrofit {
		val retrofit = Retrofit.Builder()
				.baseUrl(FoursquareUsecaseImpl.baseUrlAuth)
				.addConverterFactory(GsonConverterFactory.create())
				.build()
		
		return retrofit
	}
	
	@Test fun testAuthFoursquare() {
		
		val url : String = "https://foursquare.com/oauth2/authenticate?client_id=OJRCA0HT2UMLW4TJ4RER42OACUXITZ4VDMTUHXINVC5SYL1T&response_type=UT1QIQK2PEWTRZNFWZNEJNBMNFOZZFXGUEZUJ5HD5VX3D2QF&redirect_uri=https://test-wishlister.herokuapp.com/foursquare/callback"
				
		val foursquareGateway: FoursquareGateway = getRetrofitAuth().create(FoursquareGateway::class.java)
		val callResponse : Call<ResponseBody> = foursquareGateway.authFoursquare(
				FoursquareUsecaseImpl.client_id,
				FoursquareUsecaseImpl.client_secret,
				FoursquareUsecaseImpl.redirect_uri)
		
		assertEquals(callResponse.request().url().toString(), url)
	}
	
	@Test fun testAccessToken() {
		
		// Alterar forma de chamar a API para aceitar #_=_ (encode)
		val url : String = "https://foursquare.com/oauth2/access_token?client_id=OJRCA0HT2UMLW4TJ4RER42OACUXITZ4VDMTUHXINVC5SYL1T&client_secret=UT1QIQK2PEWTRZNFWZNEJNBMNFOZZFXGUEZUJ5HD5VX3D2QF&grant_type=https://test-wishlister.herokuapp.com/foursquare/callback&redirect_uri=authorization_code&code=PDHYDF5RPB3F2GY0GLYNX1VGTUU3IP4ZPWCR0R0RI2A3QJSL%23_%3D_"
		
		val foursquareGateway: FoursquareGateway = getRetrofitAuth().create(FoursquareGateway::class.java)
		val callResponse : Call<AccessTokenResponse> = foursquareGateway.accessToken(
				FoursquareUsecaseImpl.client_id,
				FoursquareUsecaseImpl.client_secret,
				FoursquareUsecaseImpl.redirect_uri,
				FoursquareUsecaseImpl.grant_type,
				"PDHYDF5RPB3F2GY0GLYNX1VGTUU3IP4ZPWCR0R0RI2A3QJSL#_=_")
		
		assertEquals(callResponse.request().url().toString(), url)
    }
	
	@Test fun testSearchVenue() {
		
		val url : String = "https://api.foursquare.com/v2/venues/search?client_id=OJRCA0HT2UMLW4TJ4RER42OACUXITZ4VDMTUHXINVC5SYL1T&client_secret=UT1QIQK2PEWTRZNFWZNEJNBMNFOZZFXGUEZUJ5HD5VX3D2QF&v=20170801&ll=40.7243,-74.0018"
				
		val foursquareGateway: FoursquareGateway = getRetrofit().create(FoursquareGateway::class.java)
		val callResponse : Call<SearchVenuesResponse> = foursquareGateway.searchVenue(
				FoursquareUsecaseImpl.client_id,
				FoursquareUsecaseImpl.client_secret,
				FoursquareUsecaseImpl.v,
				FoursquareUsecaseImpl.ll)
		
		assertEquals(callResponse.request().url().toString(), url)
	}
	
	@Test fun testPhotos() {
		val venueId : String =  "4a942a25f964a520972020e3"
		val url : String = "https://api.foursquare.com/v2/venues/4a942a25f964a520972020e3/photos?client_id=OJRCA0HT2UMLW4TJ4RER42OACUXITZ4VDMTUHXINVC5SYL1T&client_secret=UT1QIQK2PEWTRZNFWZNEJNBMNFOZZFXGUEZUJ5HD5VX3D2QF&v=20170801"
				
		val foursquareGateway: FoursquareGateway = getRetrofit().create(FoursquareGateway::class.java)
		val callResponse : Call<PhotosDetailsResponse> = foursquareGateway.photos(
				venueId,
				FoursquareUsecaseImpl.client_id,
				FoursquareUsecaseImpl.client_secret,
				FoursquareUsecaseImpl.v)
		
		assertEquals(callResponse.request().url().toString(), url)
	}
	
	
}

