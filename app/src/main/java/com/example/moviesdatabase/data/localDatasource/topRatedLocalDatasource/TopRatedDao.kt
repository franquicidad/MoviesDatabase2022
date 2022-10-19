package com.example.moviesdatabase.data.localDatasource.topRatedLocalDatasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesdatabase.data.localDatasource.TopRatedTable

@Dao
interface TopRatedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovies(topRatedMovies: List<TopRatedTable>)

    @Query("SELECT * FROM top_rated")
    suspend fun getTopRatedMovies(): List<TopRatedTable>
}