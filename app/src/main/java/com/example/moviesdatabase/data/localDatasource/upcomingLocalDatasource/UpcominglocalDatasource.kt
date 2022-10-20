package com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource

import com.example.moviesdatabase.data.localDatasource.UpcomingMovieTable

interface UpcominglocalDatasource {
    suspend fun insertUpcomingDbMovies(insertUpcoming:List<UpcomingMovieTable>)
    suspend fun getUpcomingDatabaseMovies(): List<UpcomingMovieTable>
}