package com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource

import com.example.moviesdatabase.MovieApp
import com.example.moviesdatabase.data.localDatasource.NinetyThreeMoviesTable

class NinetyThreeLocalDatasourceImpl : NinetyThreeLocalDatasource {
    val app =MovieApp()
    override suspend fun insertNinetyThreeDbMovies(ninetyThreeMovies: List<NinetyThreeMoviesTable>) {
        app.room.ninetyDao().insertNinetyThreeMovies(ninetyThreeMovies)
    }

    override suspend fun getNinetyThreeDatabaseMovies(): List<NinetyThreeMoviesTable> {
        return app.room.ninetyDao().getNinetyThreeMovies()
    }
}