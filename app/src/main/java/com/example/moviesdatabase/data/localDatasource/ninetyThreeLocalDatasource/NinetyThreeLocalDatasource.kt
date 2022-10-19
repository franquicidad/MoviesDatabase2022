package com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource

import com.example.moviesdatabase.data.model.Movie

interface NinetyThreeLocalDatasource {
    suspend fun getNinetyThreeDatabaseMovies(): List<Movie>
}