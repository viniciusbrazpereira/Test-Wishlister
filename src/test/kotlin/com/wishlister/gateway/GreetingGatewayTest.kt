package com.wishlister.gateway

import com.wishlister.controller.GreetingController
import com.wishlister.entities.Greeting
import com.wishlister.gateways.GreetingGateway
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.test.assertEquals

class GreetingGatewayTest {
	
    fun testAssert() : Unit {
		val greetingGateway: GreetingGateway
   
		val retrofit = Retrofit.Builder()
		    .baseUrl("http://localhost:8080")
		    .addConverterFactory(MoshiConverterFactory.create())
		    .build()
		
		greetingGateway = retrofit.create(GreetingGateway::class.java)
	        
		val response = greetingGateway.listGreeting().execute()
		
		val controller = GreetingController()
		val listEquals: List<Greeting> = controller.list()
		
		if (response.isSuccessful) {
			response?.body()?.let{
				val items: List<Greeting> = it
				for(a in items){
					assertEquals(listEquals.get(a.id.toInt()).content, a.content)
				}
			}
		}
    }
}

