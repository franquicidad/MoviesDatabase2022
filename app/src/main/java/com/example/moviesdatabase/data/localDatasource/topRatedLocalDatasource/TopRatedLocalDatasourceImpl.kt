package com.example.moviesdatabase.data.localDatasource.topRatedLocalDatasource

import com.example.moviesdatabase.MovieApp
import com.example.moviesdatabase.data.localDatasource.MovieDatabase
import com.example.moviesdatabase.data.localDatasource.TopRatedTable
import javax.inject.Inject

class TopRatedLocalDatasourceImpl @Inject constructor(
    private val room: MovieDatabase
) : TopRatedLocalDatasource {

    override suspend fun insertTopRatedDbMovies(topRatedMovies: List<TopRatedTable>) {
        room.topRatedDao().insertTopRatedMovies(topRatedMovies = topRatedMovies)
    }

    override suspend fun getTopRatedDatabaseMovies(): List<TopRatedTable> {
        return room.topRatedDao().getTopRatedMovies()
    }
}