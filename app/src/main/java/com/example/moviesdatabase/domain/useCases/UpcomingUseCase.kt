package com.example.moviesdatabase.domain.useCases

import com.example.moviesdatabase.data.repositories.upcomingrepository.UpcomingMoviesRepositoryImpl
import com.example.moviesdatabase.domain.model.MoviesDto

class UpcomingUseCase {
    private val upcomingMovieRepo = UpcomingMoviesRepositoryImpl()
    suspend fun invoke(): List<MoviesDto> {
        return upcomingMovieRepo.getUpcomingMoviesRepo().map { upcomingMovieTable ->
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