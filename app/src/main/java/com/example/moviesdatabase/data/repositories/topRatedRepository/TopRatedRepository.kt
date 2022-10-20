package com.example.moviesdatabase.data.repositories.topRatedRepository

import com.example.moviesdatabase.data.localDatasource.TopRatedTable

interface TopRatedRepository {
    suspend fun getTopRatedRepository(): List<TopRatedTable>
}