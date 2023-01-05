package com.example.moviesdatabase.data.remoteDatasource.ninetyThreeRemoteDatasource

import com.example.data.api.MovieService
import com.example.moviesdatabase.data.model.MovieResponse
import retrofit2.Response
import javax.inject.Inject

class NinetythreeRemoteDatasourceImpl @Inject constructor(
    private val apiService: MovieService,
) : NinetyThreeRemoteDatasource {
    override suspend fun getNinetyThreeRemoteDatasource(): Response<MovieResponse> {

        return apiService.getYearNinetyThreeMovies(
            MovieService.API_KEY, "1993"
        )
    }
}