package com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesdatabase.data.localDatasource.UpcomingMovieTable

@Dao
interface UpcomingMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcomingMovies(upcomingMovies: List<UpcomingMovieTable>)

    @Query("SELECT * FROM upcoming_movie")
    suspend fun getUpcomingMovies(): List<UpcomingMovieTable>


}