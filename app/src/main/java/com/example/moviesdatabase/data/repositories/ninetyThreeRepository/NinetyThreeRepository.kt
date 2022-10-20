package com.example.moviesdatabase.data.repositories.ninetyThreeRepository

import com.example.moviesdatabase.data.localDatasource.NinetyThreeMoviesTable

interface NinetyThreeRepository {
    suspend fun getNinetyThreeRepositoryMovies(): List<NinetyThreeMoviesTable>
}