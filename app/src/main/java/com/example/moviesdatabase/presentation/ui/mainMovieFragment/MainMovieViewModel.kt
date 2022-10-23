package com.example.moviesdatabase.presentation.ui.mainMovieFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesdatabase.domain.EmptyMoviesContent
import com.example.moviesdatabase.domain.model.MoviesDto
import com.example.moviesdatabase.domain.useCases.NinetyThreeMoviesUseCase
import com.example.moviesdatabase.domain.useCases.SpanishMoviesUseCase
import com.example.moviesdatabase.domain.useCases.TopRatedUseCase
import com.example.moviesdatabase.domain.useCases.UpcomingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@HiltViewModel
class MainMovieViewModel @Inject constructor(
    private val upcomingUseCase: UpcomingUseCase,
    private val topRatedUseCase: TopRatedUseCase,
    private val spanishMoviesUseCase: SpanishMoviesUseCase,
    private val ninetyThreeMoviesUseCase: NinetyThreeMoviesUseCase
) : ViewModel() {

    private lateinit var upcomingListDto: List<MoviesDto>
    private lateinit var topRatedListDto: List<MoviesDto>
    private lateinit var spanishListDto: List<MoviesDto>
    private lateinit var ninetyThreeListDto: List<MoviesDto>


    private val _recyclerUpcoming = MutableLiveData<List<MoviesDto>>()
    val recyclerUpcoming: LiveData<List<MoviesDto>> get() = _recyclerUpcoming

    private val _recyclerTopRated = MutableLiveData<List<MoviesDto>>()
    val recyclerTopRated: LiveData<List<MoviesDto>> get() = _recyclerTopRated

    private val _recyclerSpanish = MutableLiveData<List<MoviesDto>>()
    val recyclerSpanish: LiveData<List<MoviesDto>> get() = _recyclerSpanish

    private val _recyclerNinetyThree = MutableLiveData<List<MoviesDto>>()
    val recyclerNinetyThree: LiveData<List<MoviesDto>> get() = _recyclerNinetyThree

    fun getUpcomingMovies(){
        viewModelScope.launch {
            upcomingListDto = upcomingUseCase.invoke()
            _recyclerUpcoming.postValue(upcomingListDto)
        }
    }
    fun getTopRatedMovies() {

    }
}