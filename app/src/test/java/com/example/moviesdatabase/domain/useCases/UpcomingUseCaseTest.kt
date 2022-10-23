package com.example.moviesdatabase.domain.useCases

import com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource.UpcominglocalDatasource
import com.example.moviesdatabase.data.mocks.ModelMocks
import com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource.UpcomingRemoteDatasource
import com.example.moviesdatabase.data.repositories.upcomingrepository.UpcomingMovieRepository
import com.example.moviesdatabase.domain.model.MoviesDto
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UpcomingUseCaseTest{

    @Mock
    private lateinit var upcomingMoviesRepository: UpcomingMovieRepository

    @Mock
    private lateinit var upcomingLocalDatasource: UpcominglocalDatasource

    @Mock
    private lateinit var upcomingRemoteDatasource: UpcomingRemoteDatasource


    lateinit var upcomingUseCase: UpcomingUseCase

    @Before
    fun Before(){
        upcomingUseCase = UpcomingUseCase(upcomingMoviesRepository)
    }

    @Test
    fun `Get upcoming movie list`(){
        runBlocking {
            //Given
            val upcomingMovieTable = ModelMocks.getListUpcomingTable()
            val upcomingMovieDto = ModelMocks.getMovieDto()
            val upcomingTableMapped = upcomingMovieDto.map {
                MoviesDto(
                    0,
                    adult = false,
                    backdrop_path = "werwfsdf",
                    original_language = "en",
                    original_title = "Fly",
                    overview = "This is a movie to fly",
                    popularity = 5.0,
                    poster_path = "dfsdfsdf.jpeg",
                    release_date = "1993-05-06",
                    title = "Fly",
                    video = false,
                    vote_average = 5.0,
                    vote_count = 5
                )
            }
            Mockito.`when`(upcomingMoviesRepository.getUpcomingMoviesRepo()).thenReturn(upcomingMovieTable)

            //When
            val response=upcomingUseCase.invoke()

            //Then
            assert(response == upcomingTableMapped)


        }
    }

}