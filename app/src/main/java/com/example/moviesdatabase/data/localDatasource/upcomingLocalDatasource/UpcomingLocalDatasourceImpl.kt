package com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource

import com.example.moviesdatabase.data.localDatasource.MovieDatabase
import com.example.moviesdatabase.data.localDatasource.UpcomingMovieTable
import javax.inject.Inject

class UpcomingLocalDatasourceImpl @Inject constructor(
    private val room : MovieDatabase
): UpcominglocalDatasource {

    override suspend fun insertUpcomingDbMovies(insertUpcoming: List<UpcomingMovieTable>) {
        room.upcomingMovieDao().insertUpcomingMovies(insertUpcoming)
    }

    override suspend fun getUpcomingDatabaseMovies(): List<UpcomingMovieTable> {
        return room.upcomingMovieDao().getUpcomingMovies()
    }
}