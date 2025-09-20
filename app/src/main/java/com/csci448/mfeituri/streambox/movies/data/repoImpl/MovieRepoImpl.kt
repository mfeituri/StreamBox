package com.csci448.mfeituri.streambox.movies.data.repoImpl

import com.csci448.mfeituri.streambox.common.data.ApiMapper
import com.csci448.mfeituri.streambox.movies.data.remote.api.MovieAPIService
import com.csci448.mfeituri.streambox.movies.data.remote.models.MovieDto
import com.csci448.mfeituri.streambox.movies.domain.models.Movie
import com.csci448.mfeituri.streambox.movies.domain.repository.MovieRepo
import com.csci448.mfeituri.streambox.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieRepoImpl(
    private val movieAPIService: MovieAPIService,
    private val apiMapper: ApiMapper<List<Movie>, MovieDto>
): MovieRepo {


    override fun fetchDiscoverMovie(): Flow<Response<List<Movie>>> = flow  {
        emit(Response.Loading())
        val movieDto = movieAPIService.fetchDiscoverMovie()
        apiMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(data = this))
        }
    } .catch { e ->
        emit(Response.Error(e))
    } as Flow<Response<List<Movie>>>


    override fun fetchTrendingMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading())
        val movieDto = movieAPIService.fetchTrendingMovie()
        apiMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(data = this))
        }
    } .catch { e ->
        emit(Response.Error(e))
    } as Flow<Response<List<Movie>>>

}

