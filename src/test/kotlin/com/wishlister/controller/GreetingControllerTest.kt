package com.wishlister.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

/* @RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerTest {
	
	@Autowired
    lateinit var restTemplate: TestRestTemplate
 
    @Test
    fun testGreeting() {
 
        // Given
        val name = "Duke"
 
        // When
        val body = restTemplate.getForObject("/greeting/?name={name}", String::class.java, name)

        // Then
        assertThat(body).contains(name)
 
    }
	
	@Test
    fun testGreetings() {
        // When
        val body = restTemplate.getForObject("/greetings", String::class.java)

        // Then
        assertThat(body).isNotNull()
 
    }
}
*/


