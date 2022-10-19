package com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.moviesdatabase.data.localDatasource.NinetyThreeMoviesTable

@Dao
interface NinetyThreeDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertNinetyThreeMovies(movie:List<NinetyThreeMoviesTable>)

    @Query("SELECT * FROM upcoming_movie")
    suspend fun getNinetyThreeMovies(): List<NinetyThreeMoviesTable>
}