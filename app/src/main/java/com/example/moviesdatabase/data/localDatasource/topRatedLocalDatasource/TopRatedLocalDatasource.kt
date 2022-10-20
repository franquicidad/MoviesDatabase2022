package com.example.moviesdatabase.data.localDatasource.topRatedLocalDatasource

import com.example.moviesdatabase.data.localDatasource.TopRatedTable

interface TopRatedLocalDatasource {
    suspend fun insertTopRatedDbMovies(topRatedMovies:List<TopRatedTable>)
    suspend fun getTopRatedDatabaseMovies(): List<TopRatedTable>
}