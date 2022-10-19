package com.example.moviesdatabase.data.remoteDatasource.getSpanishMoviesRemoteDatasource

import com.example.moviesdatabase.data.model.MovieResponse

interface SpanishMoviesRemoteDatasource {
    suspend fun getSpanishMoviesRemoteDatasource():MovieResponse
}