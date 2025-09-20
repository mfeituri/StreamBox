package com.csci448.mfeituri.streambox.movies.domain.repository

import com.csci448.mfeituri.streambox.movies.domain.models.Movie
import com.csci448.mfeituri.streambox.utils.Response
import kotlinx.coroutines.flow.Flow

interface MovieRepo {
    fun fetchDiscoverMovie(): Flow<Response<List<Movie>>>
    fun fetchTrendingMovie(): Flow<Response<List<Movie>>>
}