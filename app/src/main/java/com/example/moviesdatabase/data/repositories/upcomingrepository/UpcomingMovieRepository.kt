package com.example.moviesdatabase.data.repositories.upcomingrepository

import com.example.moviesdatabase.data.localDatasource.UpcomingMovieTable

interface UpcomingMovieRepository {
    suspend fun getUpcomingMoviesRepo(): List<UpcomingMovieTable>
}