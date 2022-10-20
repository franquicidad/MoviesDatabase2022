package com.example.moviesdatabase.data.localDatasource.spanishLocalDatasource

import com.example.moviesdatabase.data.localDatasource.SpanishTable
import com.example.moviesdatabase.data.model.Movie

interface SpanishLocalDatasource {
    suspend fun insertSpanishDbMovies(spanishMovies:List<SpanishTable>)
    suspend fun getSpanishDatabaseMovies():List<SpanishTable>
}