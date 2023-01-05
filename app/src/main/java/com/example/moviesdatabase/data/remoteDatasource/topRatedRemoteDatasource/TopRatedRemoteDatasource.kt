package com.example.moviesdatabase.data.remoteDatasource.topRatedRemoteDatasource

import com.example.moviesdatabase.data.model.MovieResponse
import retrofit2.Response

interface TopRatedRemoteDatasource {
    suspend fun getTopRatedMoviesRemoteDatasource(): Response<MovieResponse>
}