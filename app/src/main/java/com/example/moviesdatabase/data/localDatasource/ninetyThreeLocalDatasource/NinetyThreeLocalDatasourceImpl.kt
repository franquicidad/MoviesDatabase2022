package com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource

import com.example.moviesdatabase.data.localDatasource.MovieDatabase
import com.example.moviesdatabase.data.localDatasource.NinetyThreeMoviesTable
import javax.inject.Inject

class NinetyThreeLocalDatasourceImpl @Inject constructor(
    private val room: MovieDatabase,
) : NinetyThreeLocalDatasource {
    override suspend fun insertNinetyThreeDbMovies(ninetyThreeMovies: List<NinetyThreeMoviesTable>) {
        room.ninetyDao().insertPopularMovies(ninetyThreeMovies)
    }

    override suspend fun getNinetyThreeDatabaseMovies(): List<NinetyThreeMoviesTable> {
        return room.ninetyDao().getPopularMovies()
    }
}