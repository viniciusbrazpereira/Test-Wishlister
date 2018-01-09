package com.wishlister.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeControllerTest {
	
	@Autowired
    lateinit var restTemplate: TestRestTemplate
 
    @Test
    fun testGreeting() {
        // When
        val body = restTemplate.getForObject("/welcome", String::class.java)

        // Then
        assertThat(body).isNotNull()
    }
	
	@Test
    fun testGreetings() {
        // When
        val body = restTemplate.getForObject("/greetings", String::class.java)

        // Then
        assertThat(body).isNotNull()
 
    }
}


