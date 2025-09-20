package com.csci448.mfeituri.streambox.movies.domain.models

data class Movie(
    val backdropPath: String,
    val genreIds: List<String>,
    val id: Int,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val originalLanguage: String,
    val voteCount: Any,
    val video: Boolean


)
