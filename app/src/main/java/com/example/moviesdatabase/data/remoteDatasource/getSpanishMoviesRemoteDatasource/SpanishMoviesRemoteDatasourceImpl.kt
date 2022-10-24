package com.example.moviesdatabase.data.remoteDatasource.getSpanishMoviesRemoteDatasource

import com.example.data.api.MovieService
import com.example.data.api.service
import com.example.moviesdatabase.data.model.MovieResponse
import javax.inject.Inject

class SpanishMoviesRemoteDatasourceImpl @Inject constructor(
    private val apiService: MovieService
):SpanishMoviesRemoteDatasource {
    override suspend fun getSpanishMoviesRemoteDatasource(): MovieResponse {
        return apiService.getSpanishMovies(MovieService.API_KEY,"en-ESP")
    }
}