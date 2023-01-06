package com.example.moviesdatabase.data.localDatasource.popularMoviesLocalDatasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.moviesdatabase.data.localDatasource.SpanishTable

@Dao
interface popularDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(popularMovies: List<SpanishTable>)
}