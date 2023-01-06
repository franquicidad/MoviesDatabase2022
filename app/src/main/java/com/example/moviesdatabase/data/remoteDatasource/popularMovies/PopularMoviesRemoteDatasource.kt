package com.example.moviesdatabase.data.remoteDatasource.popularMovies

import com.example.moviesdatabase.data.model.MovieResponse
import retrofit2.Response

interface PopularMoviesRemoteDatasource {
    suspend fun getRemotePopularMovies(): Response<MovieResponse>
}