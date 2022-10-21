package com.example.moviesdatabase.data.localDatasource.spanishLocalDatasource

import com.example.moviesdatabase.MovieApp
import com.example.moviesdatabase.data.localDatasource.MovieDatabase
import com.example.moviesdatabase.data.localDatasource.SpanishTable
import javax.inject.Inject

class SpanishLocalDatasourceImpl @Inject constructor(
    private val room :MovieDatabase
): SpanishLocalDatasource {

    override suspend fun insertSpanishDbMovies(spanishMovies: List<SpanishTable>) {
        room.spanishDao().insertSpanishMovies(spanishMovies)
    }

    override suspend fun getSpanishDatabaseMovies(): List<SpanishTable> {
        return room.spanishDao().getSpanishMovies()
    }
}