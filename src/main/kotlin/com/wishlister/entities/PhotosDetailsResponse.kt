package com.wishlister.entities

import com.wishlister.entities.Photos

data class PhotosDetailsResponse(
    val meta: PhotosMeta,
    val response: PhotosResponse
)

data class PhotosMeta(
    val code: Int,
    val requestId: String
)

data class PhotosResponse(
    val photos: Photos
)

