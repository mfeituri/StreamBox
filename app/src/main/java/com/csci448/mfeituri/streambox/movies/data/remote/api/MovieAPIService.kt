package com.csci448.mfeituri.streambox.movies.data.remote.api

import com.csci448.mfeituri.streambox.BuildConfig
import com.csci448.mfeituri.streambox.movies.data.remote.models.MovieDto
import com.csci448.mfeituri.streambox.utils.K
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIService {
    @GET(K.MOVIE_ENDPOINT)
    suspend fun fetchDiscoverMovie(
        @Query("api_key") apiKey: String = BuildConfig.apiKey,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto

    @GET(K.TRENDING_MOVIE_ENDPOINT)
    suspend fun fetchTrendingMovie(
        @Query("api_key") apiKey: String = BuildConfig.apiKey,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto
}
