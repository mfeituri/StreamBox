package com.csci448.mfeituri.streambox.movies.data.mapper_impl

import com.csci448.mfeituri.streambox.common.data.ApiMapper
import com.csci448.mfeituri.streambox.movies.data.remote.models.MovieDto
import com.csci448.mfeituri.streambox.movies.domain.models.Movie
import com.csci448.mfeituri.streambox.utils.GenreConstants

class MovieApiMapper: ApiMapper<List<Movie>, MovieDto> {

    private fun formatEmptyValue(value: String?, default: String = ""): String {
        if (value.isNullOrEmpty()) return "Unknown $default"
        return value
    }

        private fun formatGenre(genreIds: List<Int?>?): List<String>{
            return genreIds?.map { GenreConstants.genreNameByID(it ?: 0)} ?: emptyList()
        }

    override fun mapToDomain(apiDto: MovieDto): List<Movie>? {
        return apiDto.results?.map { result ->
            Movie(
                backdropPath = formatEmptyValue(result?.backdropPath),
                genreIds = formatGenre(result?.genreIds),
                id = result?.id ?: 0,
                originalTitle = formatEmptyValue(result?.originalTitle),
                originalLanguage = formatEmptyValue(result?.originalLanguage, default = "english"),
                overview = formatEmptyValue(result?.overview, default = "overview"),
                popularity = result?.popularity ?: 0.0,
                posterPath = formatEmptyValue(result?.posterPath),
                releaseDate = formatEmptyValue(result?.releaseDate, default = "date"),
                title = formatEmptyValue(result?.title, default = "title"),
                voteAverage = result?.voteAverage ?: 0.0,
                voteCount = result?.voteCount ?: 0.0,
                video = result?.video ?: false
            )

    }

}
}