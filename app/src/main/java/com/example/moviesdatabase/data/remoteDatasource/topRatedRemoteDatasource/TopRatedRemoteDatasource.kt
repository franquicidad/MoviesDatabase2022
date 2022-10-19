package com.example.moviesdatabase.data.remoteDatasource.topRatedRemoteDatasource

import com.example.moviesdatabase.data.model.MovieResponse

interface TopRatedRemoteDatasource {
    suspend fun getTopRatedMoviesRemoteDatasource(): MovieResponse
}