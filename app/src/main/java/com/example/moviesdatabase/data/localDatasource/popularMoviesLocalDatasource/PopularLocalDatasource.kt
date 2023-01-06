package com.example.moviesdatabase.data.localDatasource.popularMoviesLocalDatasource

import com.example.moviesdatabase.data.localDatasource.PopularTable

interface PopularLocalDatasource {
    suspend fun insertPopularMovies(popularTable: List<PopularTable>)
    suspend fun getPopularMoviesDatabaseMovies(): List<PopularTable>
}