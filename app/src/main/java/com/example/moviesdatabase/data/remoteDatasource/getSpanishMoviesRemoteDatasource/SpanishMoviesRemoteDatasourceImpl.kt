package com.example.moviesdatabase.data.remoteDatasource.getSpanishMoviesRemoteDatasource

import com.example.data.api.MovieService
import com.example.data.api.service
import com.example.moviesdatabase.data.model.MovieResponse

class SpanishMoviesRemoteDatasourceImpl:SpanishMoviesRemoteDatasource {
    override suspend fun getSpanishMoviesRemoteDatasource(): MovieResponse {
        return service.getSpanishMovies(MovieService.API_KEY,"es")
    }
}