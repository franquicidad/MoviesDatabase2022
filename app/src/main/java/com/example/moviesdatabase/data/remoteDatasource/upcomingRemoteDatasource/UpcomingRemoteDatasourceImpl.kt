package com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource

import com.example.data.api.MovieService
import com.example.data.api.service
import com.example.moviesdatabase.data.model.MovieResponse

class UpcomingRemoteDatasourceImpl: UpcomingRemoteDatasource{
    override suspend fun getUpcomingMoviesRemoteDatasource(): MovieResponse {
        return service.getUpcomingMovies(MovieService.API_KEY)
    }
}