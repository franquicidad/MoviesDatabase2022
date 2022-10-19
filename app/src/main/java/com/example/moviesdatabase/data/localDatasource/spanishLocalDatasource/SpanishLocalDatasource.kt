package com.example.moviesdatabase.data.localDatasource.spanishLocalDatasource

import com.example.moviesdatabase.data.model.Movie

interface SpanishLocalDatasource {
    suspend fun getSpanishDatabaseMovies():List<Movie>
}