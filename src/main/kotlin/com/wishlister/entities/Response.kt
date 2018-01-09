package com.wishlister.entities

data class Response (
    val venues: List<Venue>,
	val photos: List<Photos>,
    val isConfident: Boolean
)


