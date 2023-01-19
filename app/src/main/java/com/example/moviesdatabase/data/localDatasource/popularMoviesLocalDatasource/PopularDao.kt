package com.example.moviesdatabase.data.localDatasource.popularMoviesLocalDatasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesdatabase.data.localDatasource.PopularTable

@Dao
interface PopularDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(popularMovies: List<PopularTable>)

    @Query("SELECT * FROM popular_movie")
    suspend fun getPopularMovies(): List<PopularTable>
}