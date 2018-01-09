package com.wishlister.entities

public data class Photos (
	val count:Int,
	val items : List<Item>  
)

data class Item (
    val id:String,
    val createdAt:String,
    val source:Source,
    val prefix:String,
	val suffix:String,
	val width:Int,
	val height:Int,
	val visibility:String
)

data class Source (
    val code: Int,
    val requestId: String
)
