package com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource

import com.example.moviesdatabase.data.localDatasource.NinetyThreeMoviesTable
import com.example.moviesdatabase.data.model.Movie

interface NinetyThreeLocalDatasource {
    suspend fun insertNinetyThreeDbMovies(ninetyThreeMovies:List<NinetyThreeMoviesTable>)
    suspend fun getNinetyThreeDatabaseMovies(): List<NinetyThreeMoviesTable>
}