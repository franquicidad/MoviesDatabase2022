package com.example.moviesdatabase.data.localDatasource.spanishLocalDatasource

import com.example.moviesdatabase.MovieApp
import com.example.moviesdatabase.data.localDatasource.SpanishTable

class SpanishLocalDatasourceImpl: SpanishLocalDatasource {
    val app = MovieApp()
    override suspend fun insertSpanishDbMovies(spanishMovies: List<SpanishTable>) {
        app.room.spanishDao().insertSpanishMovies(spanishMovies)
    }

    override suspend fun getSpanishDatabaseMovies(): List<SpanishTable> {
        return app.room.spanishDao().getSpanishMovies()
    }
}