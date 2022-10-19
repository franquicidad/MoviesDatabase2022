package com.example.moviesdatabase.data.remoteDatasource.ninetyThreeRemoteDatasource

import com.example.moviesdatabase.data.model.MovieResponse

interface NinetyThreeRemoteDatasource {
    suspend fun getNinetyThreeRemoteDatasource():MovieResponse
}