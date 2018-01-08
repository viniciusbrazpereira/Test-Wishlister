package com.wishlister

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun startHost(args: Array<String>){
	SpringApplication.run(Application::class.java, *args)
}

fun main(args: Array<String>) {
   startHost(args)
   println(" **** Spring Boot Kotlin RESTful Web Services *****")
}