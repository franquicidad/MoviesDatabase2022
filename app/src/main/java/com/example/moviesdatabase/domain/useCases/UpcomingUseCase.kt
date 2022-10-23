package com.example.moviesdatabase.domain.useCases

import com.example.moviesdatabase.data.repositories.topRatedRepository.TopRatedRepository
import com.example.moviesdatabase.data.repositories.upcomingrepository.UpcomingMovieRepository
import com.example.moviesdatabase.data.repositories.upcomingrepository.UpcomingMoviesRepositoryImpl
import com.example.moviesdatabase.domain.model.MoviesDto
import javax.inject.Inject

class UpcomingUseCase @Inject constructor(
    private val upcomingRepository: UpcomingMovieRepository
) {
    suspend operator fun invoke(): List<MoviesDto> {
        return upcomingRepository.getUpcomingMoviesRepo().map { upcomingMovieTable ->
            MoviesDto(
                upcomingMovieTable.id,
                upcomingMovieTable.adult,
                upcomingMovieTable.backdrop_path,
                upcomingMovieTable.original_language,
                upcomingMovieTable.original_title,
                upcomingMovieTable.overview,
                upcomingMovieTable.popularity,
                upcomingMovieTable.poster_path,
                upcomingMovieTable.release_date,
                upcomingMovieTable.title,
                upcomingMovieTable.video,
                upcomingMovieTable.vote_average,
                upcomingMovieTable.vote_count
            )
        }
    }
}