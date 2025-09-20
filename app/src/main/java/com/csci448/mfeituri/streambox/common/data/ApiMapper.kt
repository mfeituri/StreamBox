package com.csci448.mfeituri.streambox.common.data

import android.icu.text.UnicodeSet
import com.csci448.mfeituri.streambox.movies.data.remote.models.MovieDto
import com.csci448.mfeituri.streambox.movies.domain.models.Movie

interface ApiMapper<Domain, Entity> {

    fun mapToDomain(apiDto: Entity): List<Movie>?

}