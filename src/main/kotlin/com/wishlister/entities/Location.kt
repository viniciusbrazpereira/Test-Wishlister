package com.wishlister.entities


/**
 * Data object that describes a location of a venue fetched from Foursquare API
 *
 * @author Vinicius Braz Pereira
 */
public data class Location
(
    val lat:Double? = null,
    val lng:Double? = null,
    val distance:Int? = null,
    val address:String? = null,
    val crossStreet:String? = null,
    val city:String? = null,
    val state:String? = null,
    val postalCode:String? = null,
    val country:String? = null
)


