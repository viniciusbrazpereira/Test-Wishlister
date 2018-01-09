package com.wishlister.entities

import com.wishlister.entities.Stats
import com.wishlister.entities.RatingLoadingStatus

/**
 * Data object that describes a venue fetched from Foursquare API
 *
 * @author Vinicius Braz Pereira
 */
public data class Venue
(
    val id:String,
    val name:String,
    val location:Location,
    val mainCategory:Category?,
    val verified:Boolean,
    val stats:Stats,
    var ratingAvailability:RatingLoadingStatus = RatingLoadingStatus.NOT_LOADED,
    var rating:Double? = null
)

