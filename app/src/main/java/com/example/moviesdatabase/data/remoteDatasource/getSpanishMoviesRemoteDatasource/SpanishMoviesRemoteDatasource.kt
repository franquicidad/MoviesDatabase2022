package com.example.moviesdatabase.data.remoteDatasource.getSpanishMoviesRemoteDatasource

import com.example.moviesdatabase.data.model.MovieResponse
import retrofit2.Response

interface SpanishMoviesRemoteDatasource {
    suspend fun getSpanishMoviesRemoteDatasource(): Response<MovieResponse>
}