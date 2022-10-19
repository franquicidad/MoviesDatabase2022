package com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource

import com.example.moviesdatabase.data.model.Movie

interface UpcominglocalDatasource {
    suspend fun getUpcomingDatabaseMovies(): List<Movie>
}