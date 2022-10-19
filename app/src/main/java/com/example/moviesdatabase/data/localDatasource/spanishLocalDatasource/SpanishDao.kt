package com.example.moviesdatabase.data.localDatasource.spanishLocalDatasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesdatabase.data.localDatasource.SpanishTable

@Dao
interface SpanishDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpanishMovies(spanishMovies: List<SpanishTable>)

    @Query("SELECT * FROM spanish")
    suspend fun getSpanishMovies(): List<SpanishTable>
}