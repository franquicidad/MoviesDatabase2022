package com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource

import com.example.data.api.MovieService
import com.example.moviesdatabase.data.mocks.ModelMocks

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UpcomingRemoteDatasourceImplTest {
    @Mock
    lateinit var apiService: MovieService

    lateinit var upcomingRemoteDatasource: UpcomingRemoteDatasource

    @Before
    fun setUp() {
        upcomingRemoteDatasource = UpcomingRemoteDatasourceImpl(apiService)
    }

    @Test
    fun `getUpcomingRemoteTest`() {
        runBlocking {
            //Given
            val apiKey = "1234"
            val movieResponse = ModelMocks.getMovieResponse()
            `when`(apiService.getUpcomingMovies(apiKey)).thenReturn(movieResponse)

            //When
            val response = apiService.getUpcomingMovies(apiKey)

            //Then
            assert(response == movieResponse)
        }
    }
}