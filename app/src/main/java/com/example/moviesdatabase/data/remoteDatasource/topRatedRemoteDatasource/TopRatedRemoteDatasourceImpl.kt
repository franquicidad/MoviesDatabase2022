package com.example.moviesdatabase.data.remoteDatasource.topRatedRemoteDatasource

import com.example.data.api.MovieService
import com.example.data.api.service
import com.example.moviesdatabase.data.model.MovieResponse

class TopRatedRemoteDatasourceImpl : TopRatedRemoteDatasource{
    override suspend fun getTopRatedMoviesRemoteDatasource(): MovieResponse {
        return service.getTopRatedMovies(MovieService.API_KEY)
    }
}