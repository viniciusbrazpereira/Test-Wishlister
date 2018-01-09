package com.wishlister.entities


/**
 * Enum that defines state of loading for a rating
 */
enum class RatingLoadingStatus
{
    /**
     * Rating has not been fetched
     */
    NOT_LOADED,
    /**
     * Rating is currently fetched
     */
    LOADING,
    /**
     * The rating is fetched and available
     */
    AVAILABLE,
    /**
     * The rating is fetched but not available
     */
    NOT_AVAILABLE,
    /**
     * An error occured during rating fetching
     */
    ERROR
}


