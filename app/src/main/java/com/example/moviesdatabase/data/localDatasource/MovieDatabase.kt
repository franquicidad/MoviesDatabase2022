package com.example.moviesdatabase.data.localDatasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource.NinetyThreeDao
import com.example.moviesdatabase.data.localDatasource.popularMoviesLocalDatasource.PopularDao
import com.example.moviesdatabase.data.localDatasource.spanishLocalDatasource.SpanishDao
import com.example.moviesdatabase.data.localDatasource.topRatedLocalDatasource.TopRatedDao
import com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource.UpcomingMovieDao

@Database(
    entities = [
        NinetyThreeMoviesTable::class,
        SpanishTable::class,
        TopRatedTable::class,
        UpcomingMovieTable::class,
        PopularTable::class
    ], version = 8
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun upcomingMovieDao(): UpcomingMovieDao
    abstract fun topRatedDao(): TopRatedDao
    abstract fun spanishDao(): SpanishDao
    abstract fun ninetyDao(): NinetyThreeDao
    abstract fun popularDao(): PopularDao
}


