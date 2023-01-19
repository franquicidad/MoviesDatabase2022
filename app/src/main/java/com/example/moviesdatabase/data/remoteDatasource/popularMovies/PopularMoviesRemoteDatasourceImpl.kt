package com.example.moviesdatabase.data.remoteDatasource.popularMovies

import com.example.data.api.MovieService
import com.example.moviesdatabase.data.model.MovieResponse
import retrofit2.Response
import javax.inject.Inject

class PopularMoviesRemoteDatasourceImpl @Inject constructor(
    private val apiService: MovieService,
) : PopularMoviesRemoteDatasource {
    override suspend fun getRemotePopularMovies(): Response<MovieResponse> {
        return apiService.getPopularMovies(MovieService.API_KEY)
    }
}