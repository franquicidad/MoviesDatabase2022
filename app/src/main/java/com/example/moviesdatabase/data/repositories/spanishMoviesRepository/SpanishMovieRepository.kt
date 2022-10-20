package com.example.moviesdatabase.data.repositories.spanishMoviesRepository

import com.example.moviesdatabase.data.localDatasource.SpanishTable

interface SpanishMovieRepository {
    suspend fun getSpanishMoviesRepository() : List<SpanishTable>
}