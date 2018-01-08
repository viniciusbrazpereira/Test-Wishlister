package com.wishlister.controller

import com.wishlister.entities.Greeting
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import retrofit2.http.GET
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter = AtomicLong()
	
    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")
	
	@GetMapping("/greetings")
	fun list() : List<Greeting>{
		return listOf(
				Greeting(1, "Vinicius"),
				Greeting(2, "Leonardo"),
				Greeting(3, "Luciane"))
	}

}
