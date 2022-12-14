package com.example.moviesdatabase.presentation.ui.mainMovieFragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesdatabase.data.mocks.ModelMocks
import com.example.moviesdatabase.domain.useCases.NinetyThreeMoviesUseCase
import com.example.moviesdatabase.domain.useCases.SpanishMoviesUseCase
import com.example.moviesdatabase.domain.useCases.TopRatedUseCase
import com.example.moviesdatabase.domain.useCases.UpcomingUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainMovieViewModelTest {
    @Mock
    private lateinit var upcomingUseCase: UpcomingUseCase

    @Mock
    private lateinit var topRatedUseCase: TopRatedUseCase

    @Mock
    private lateinit var spanishMoviesUseCase: SpanishMoviesUseCase

    @Mock
    private lateinit var ninetyThreeMoviesUseCase: NinetyThreeMoviesUseCase

    lateinit var mainMovieViewModel: MainMovieViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        mainMovieViewModel = MainMovieViewModel(upcomingUseCase,
            topRatedUseCase,
            spanishMoviesUseCase,
            ninetyThreeMoviesUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `retreive upcoming list from useCase`() {
        runTest {
            val listMoviesDto = ModelMocks.getUpcomingMovieDto()
            Mockito.`when`(upcomingUseCase.invoke()).thenReturn(listMoviesDto)
            mainMovieViewModel.getGetMainScreenMovies()

            assert(mainMovieViewModel.recyclerUpcoming.value == listMoviesDto)
        }
    }
}
