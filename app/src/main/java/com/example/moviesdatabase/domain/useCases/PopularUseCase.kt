package com.example.moviesdatabase.domain.useCases

import com.example.moviesdatabase.data.repositories.popularRepository.PopularMovieRepository
import com.example.moviesdatabase.domain.model.MoviesDto
import javax.inject.Inject

class PopularUseCase @Inject constructor(
    private val popularRepository: PopularMovieRepository,
) {
    suspend operator fun invoke(): List<MoviesDto> {
        return popularRepository.getPopularMoviesRepository().map { popularMovie ->
            MoviesDto(
                0,
                popularMovie.adult,
                popularMovie.backdrop_path,
                popularMovie.original_language,
                popularMovie.original_title,
                popularMovie.overview,
                popularMovie.popularity,
                popularMovie.poster_path,
                popularMovie.release_date,
                popularMovie.title,
                popularMovie.video,
                popularMovie.vote_average,
                popularMovie.vote_count
            )
        }
    }
}
