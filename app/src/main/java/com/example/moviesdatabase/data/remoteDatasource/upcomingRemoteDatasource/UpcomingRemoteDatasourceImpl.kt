package com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource

import com.example.data.api.MovieService
import com.example.data.api.service
import com.example.moviesdatabase.data.model.MovieResponse
import javax.inject.Inject

class UpcomingRemoteDatasourceImpl @Inject constructor(
    private val apiService: MovieService
) : UpcomingRemoteDatasource {
    override suspend fun getUpcomingMoviesRemoteDatasource(): MovieResponse {
        return apiService.getUpcomingMovies(MovieService.API_KEY)
    }
}