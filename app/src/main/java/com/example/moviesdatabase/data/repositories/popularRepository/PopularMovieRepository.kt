package com.example.moviesdatabase.data.repositories.popularRepository

import com.example.moviesdatabase.data.localDatasource.PopularTable

interface PopularMovieRepository {
    suspend fun getPopularMoviesRepository(): List<PopularTable>
}