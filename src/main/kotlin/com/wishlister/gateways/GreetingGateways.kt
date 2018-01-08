package com.wishlister.gateways

import com.wishlister.entities.Greeting
import retrofit2.Call
import retrofit2.http.GET

interface GreetingGateway {
    fun getGreeting(id: Long) : Greeting
	
	@GET("/greetings")
	fun listGreeting() : Call<List<Greeting>>
}

