package com.example.moviesdatabase.data.remoteDatasource.ninetyThreeRemoteDatasource

import com.example.data.api.MovieService
import com.example.data.api.service
import com.example.moviesdatabase.data.model.MovieResponse

class NinetythreeRemoteDatasourceImpl:NinetyThreeRemoteDatasource {
    override suspend fun getNinetyThreeRemoteDatasource(): MovieResponse {
        return service.getYearNinetyThreeMovies(
            MovieService.API_KEY,"1993"
        )
    }
}