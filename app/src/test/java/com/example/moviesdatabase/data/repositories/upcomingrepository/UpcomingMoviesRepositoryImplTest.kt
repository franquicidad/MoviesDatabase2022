package com.example.moviesdatabase.data.repositories.upcomingrepository

import com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource.UpcominglocalDatasource
import com.example.moviesdatabase.data.mocks.ModelMocks
import com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource.UpcomingRemoteDatasource
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UpcomingMoviesRepositoryImplTest{

    @Mock
    private lateinit var upcomingLocalDatasource: UpcominglocalDatasource

    @Mock
    private lateinit var upcomingRemoteDatasource: UpcomingRemoteDatasource

    private  val upcomingRepository: UpcomingMovieRepository by lazy {
        UpcomingMoviesRepositoryImpl(upcomingLocalDatasource,upcomingRemoteDatasource)
    }

    @Test
    fun `when there is no movies on the database and the table is empty`() {
        runBlocking {
            //Given
            val upcomingListMovieTable = ModelMocks.getListUpcomingTable()
            Mockito.`when`(upcomingLocalDatasource.getUpcomingDatabaseMovies()).thenReturn(emptyList())

//            Mockito.`when`(upcomingLocalDatasource.insertUpcomingDbMovies(upcomingListMovieTable))

            val result = upcomingRepository.getUpcomingMoviesRepo()

            assert(result == upcomingListMovieTable)
        }
    }

    @Test
    fun `retreive movies from database`(){
        runBlocking {
            //Given
            val upcomingListMovieTable = ModelMocks.getListUpcomingTable()
            Mockito.`when`(upcomingLocalDatasource.getUpcomingDatabaseMovies()).thenReturn(upcomingListMovieTable)

            val result = upcomingRepository.getUpcomingMoviesRepo()

            assert(upcomingListMovieTable == result)



        }
    }

}