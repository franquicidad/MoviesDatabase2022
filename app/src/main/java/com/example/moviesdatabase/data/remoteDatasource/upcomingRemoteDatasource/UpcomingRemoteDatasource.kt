package com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource

import com.example.moviesdatabase.data.model.MovieResponse

interface UpcomingRemoteDatasource {
    suspend fun getUpcomingMoviesRemoteDatasource():MovieResponse
}