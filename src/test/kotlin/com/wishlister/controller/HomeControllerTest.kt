package com.wishlister.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

/*
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeControllerTest {
	
	@Autowired
    lateinit var restTemplate: TestRestTemplate
 
	@Test
    fun testAuth() {
        // When
        val body = restTemplate.getForObject("/auth", String::class.java)

        // Then
        assertThat(body).isNotNull()
    }
	
	@Test
    fun testCallback() {
		val url = "/foursquare/callback?code=PDHYDF5RPB3F2GY0GLYNX1VGTUU3IP4ZPWCR0R0RI2A3QJSL#_=_"
        // When
        val body = restTemplate.getForObject(url, String::class.java)

        // Then
		//assertThat(body).contains("PDHYDF5RPB3F2GY0GLYNX1VGTUU3IP4ZPWCR0R0RI2A3QJSL#_=_")
    }
	
}


*/