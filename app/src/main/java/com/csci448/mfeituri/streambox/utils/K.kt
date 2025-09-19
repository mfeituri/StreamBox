package com.csci448.mfeituri.streambox.utils

object K {
    // singleton object for API endpoints for when we do our get requests

    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    const val MOVIE_ENDPOINT = "discover/movie"
    const val MOVIE_DETAIL_ENDPOINT = "movie"
    const val MOVIE_ACTOR_ENDPOINT = "person"
    const val TRENDING_MOVIE_ENDPOINT = "trending/movie/week"
    const val MOVIE_ID = "id"
    const val ACTOR_ID = "id"
}