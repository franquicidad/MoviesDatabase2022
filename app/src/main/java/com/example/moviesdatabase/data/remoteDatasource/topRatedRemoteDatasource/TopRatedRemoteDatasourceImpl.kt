package com.example.moviesdatabase.data.remoteDatasource.topRatedRemoteDatasource

import com.example.data.api.MovieService
import com.example.moviesdatabase.data.model.MovieResponse
import retrofit2.Response
import javax.inject.Inject

class TopRatedRemoteDatasourceImpl @Inject constructor(
    private val apiService: MovieService,
) : TopRatedRemoteDatasource {
    override suspend fun getTopRatedMoviesRemoteDatasource(): Response<MovieResponse> {
        return apiService.getTopRatedMovies(MovieService.API_KEY)
    }
}