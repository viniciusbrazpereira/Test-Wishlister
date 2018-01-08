package com.wishlister.gateway

import com.wishlister.gateways.FoursquareGateway
import com.wishlister.entities.SearchVenuesResponse
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.test.assertNotNull
import kotlin.test.assertTrue


class FoursquareGatewayImplTest {
	var baseUrl : String = "https://api.foursquare.com/"
	val client_id: String = "OJRCA0HT2UMLW4TJ4RER42OACUXITZ4VDMTUHXINVC5SYL1T"
	val client_secret: String = "UT1QIQK2PEWTRZNFWZNEJNBMNFOZZFXGUEZUJ5HD5VX3D2QF"
	val v: String = "20170801"
	val ll: String = "40.7243,-74.0018"
	
	@Test fun testAssert(): Unit {
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
				assertNotNull(searchVenuesResponse?.response?.venues)
			}
		} else {
		   assertTrue(false)
		}
	}
}

