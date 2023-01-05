package com.example.moviesdatabase.data.remoteDatasource.ninetyThreeRemoteDatasource

import com.example.moviesdatabase.data.model.MovieResponse
import retrofit2.Response

interface NinetyThreeRemoteDatasource {
    suspend fun getNinetyThreeRemoteDatasource(): Response<MovieResponse>
}