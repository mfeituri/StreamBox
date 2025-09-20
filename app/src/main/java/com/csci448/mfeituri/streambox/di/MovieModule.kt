package com.csci448.mfeituri.streambox.di

import com.csci448.mfeituri.streambox.common.data.ApiMapper
import com.csci448.mfeituri.streambox.movies.data.mapper_impl.MovieApiMapper
import com.csci448.mfeituri.streambox.movies.data.remote.api.MovieAPIService
import com.csci448.mfeituri.streambox.movies.data.remote.models.MovieDto
import com.csci448.mfeituri.streambox.movies.data.repoImpl.MovieRepoImpl
import com.csci448.mfeituri.streambox.movies.domain.models.Movie
import com.csci448.mfeituri.streambox.movies.domain.repository.MovieRepo
import com.csci448.mfeituri.streambox.utils.K
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType


import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {
    private val json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }
    @Provides
    @Singleton
    fun provideMovieRepository(
        movieAPIService: MovieAPIService,
        mapper: ApiMapper<List<Movie>, MovieDto>
    ): MovieRepo = MovieRepoImpl(
        movieAPIService, mapper
    )
    @Provides
    @Singleton
    fun provideMovieMapper(): ApiMapper<List<Movie>, MovieDto> = MovieApiMapper()

    @Provides
    @Singleton
    fun provideMovieApiService(): MovieAPIService {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(K.BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(MovieAPIService:: class.java )
    }

}


