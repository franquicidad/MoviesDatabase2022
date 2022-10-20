package com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource

import com.example.moviesdatabase.MovieApp
import com.example.moviesdatabase.data.localDatasource.UpcomingMovieTable

class UpcomingLocalDatasourceImpl: UpcominglocalDatasource {
    val app = MovieApp()
    override suspend fun insertUpcomingDbMovies(insertUpcoming: List<UpcomingMovieTable>) {
        app.room.upcomingMovieDao().insertUpcomingMovies(insertUpcoming)
    }

    override suspend fun getUpcomingDatabaseMovies(): List<UpcomingMovieTable> {
        return app.room.upcomingMovieDao().getUpcomingMovies()
    }
}