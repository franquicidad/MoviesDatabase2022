package com.example.moviesdatabase.data.localDatasource.topRatedLocalDatasource

import com.example.moviesdatabase.MovieApp
import com.example.moviesdatabase.data.localDatasource.TopRatedTable

class TopRatedLocalDatasourceImpl :TopRatedLocalDatasource {
    val app =MovieApp()
    override suspend fun insertTopRatedDbMovies(topRatedMovies: List<TopRatedTable>) {
        app.room.topRatedDao().insertTopRatedMovies(topRatedMovies =topRatedMovies )
    }

    override suspend fun getTopRatedDatabaseMovies(): List<TopRatedTable> {
        return app.room.topRatedDao().getTopRatedMovies()
    }
}