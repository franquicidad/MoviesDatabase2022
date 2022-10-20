package com.example.moviesdatabase

import android.app.Application
import androidx.room.Room
import com.example.moviesdatabase.data.localDatasource.MovieDatabase

class MovieApp : Application() {
    val room = Room
        .databaseBuilder(this, MovieDatabase::class.java,"movie-db").build()

}