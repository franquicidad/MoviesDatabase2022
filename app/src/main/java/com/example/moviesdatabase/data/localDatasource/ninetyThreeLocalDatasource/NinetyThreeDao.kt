package com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesdatabase.data.localDatasource.PopularTable

@Dao
interface NinetyThreeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(movie: List<PopularTable>)

    @Query("SELECT * FROM popular_movie")
    suspend fun getPopularMovies(): List<PopularTable>
}