package com.example.moviesdatabase.data.localDatasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource.UpcomingMovieDao

@Database(
    entities = [
        NinetyThreeMoviesTable::class,
    SpanishTable::class,
    TopRatedTable::class,
    UpcomingMovieTable::class
    ], version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): UpcomingMovieDao
}

