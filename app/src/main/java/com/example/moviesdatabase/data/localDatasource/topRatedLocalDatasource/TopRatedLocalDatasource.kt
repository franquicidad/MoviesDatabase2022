package com.example.moviesdatabase.data.localDatasource.topRatedLocalDatasource

import com.example.moviesdatabase.data.model.Movie

interface TopRatedLocalDatasource {
    suspend fun getTopRatedDatabaseMovies(): List<Movie>
}