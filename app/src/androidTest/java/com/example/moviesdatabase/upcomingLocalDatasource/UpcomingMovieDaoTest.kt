package com.example.moviesdatabase.upcomingLocalDatasource

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviesdatabase.data.localDatasource.MovieDatabase
import com.example.moviesdatabase.data.localDatasource.UpcomingMovieTable
import com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource.UpcomingMovieDao
import com.example.moviesdatabase.upcomingLocalDatasource.mockTable.MockDaos
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class UpcomingMovieDaoTest {
   private lateinit var database: MovieDatabase
   private lateinit var upcomingMovieDao: UpcomingMovieDao

   @Before
   fun initDb(){
       database = Room.inMemoryDatabaseBuilder(
           ApplicationProvider.getApplicationContext(),
           MovieDatabase::class.java).allowMainThreadQueries().build()
       upcomingMovieDao = database.upcomingMovieDao()
   }

    @After
    fun closeDb(){
        database.close()
    }

    @Test
    fun insertUpcomingMovieList()= runBlocking {
        //Given
        val listUpcomingMovieTable = MockDaos.getUpcomingMovieTable()

        //when
        upcomingMovieDao.insertUpcomingMovies(listUpcomingMovieTable)
        val response = upcomingMovieDao.getUpcomingMovies()

        //then
       assert(listUpcomingMovieTable == response)
    }
}