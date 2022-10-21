package com.example.moviesdatabase.di.repos

import android.content.Context
import androidx.room.Room
import com.example.moviesdatabase.data.localDatasource.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProvideDatabase {
    const val QUOTE_DATABASE_NAME = "movie-db"


    @Singleton
    @Provides
    fun provideMovieDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            QUOTE_DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun provideUpcomingDao(db: MovieDatabase) = db.upcomingMovieDao()

    @Singleton
    @Provides
    fun provideTopRatedDao(db: MovieDatabase) = db.topRatedDao()

    @Singleton
    @Provides
    fun provideSpanishDao(db: MovieDatabase) = db.spanishDao()

    @Singleton
    @Provides
    fun provideNinetyDao(db: MovieDatabase) = db.ninetyDao()
}