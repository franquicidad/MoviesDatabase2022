package com.example.moviesdatabase.data.localDatasource.popularMoviesLocalDatasource

import com.example.moviesdatabase.data.localDatasource.MovieDatabase
import com.example.moviesdatabase.data.localDatasource.PopularTable
import javax.inject.Inject

class PopularLocalDatasourceImpl @Inject constructor(
    private val room: MovieDatabase,
) : PopularLocalDatasource {
    override suspend fun insertPopularMovies(popularTable: List<PopularTable>) {
        return room.popularDao().insertPopularMovies(popularTable)
    }

    override suspend fun getPopularMoviesDatabaseMovies(): List<PopularTable> {
        return room.popularDao().getPopularMovies()
    }

}