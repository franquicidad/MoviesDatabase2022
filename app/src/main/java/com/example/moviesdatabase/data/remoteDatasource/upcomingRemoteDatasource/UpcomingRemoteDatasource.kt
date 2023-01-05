package com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource

import com.example.moviesdatabase.data.model.MovieResponse
import retrofit2.Response

interface UpcomingRemoteDatasource {
    suspend fun getUpcomingMoviesRemoteDatasource(): Response<MovieResponse>
}