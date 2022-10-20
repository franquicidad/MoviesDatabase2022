package com.example.moviesdatabase.domain.useCases

import com.example.moviesdatabase.data.repositories.topRatedRepository.TopRatedRepositoryImpl
import com.example.moviesdatabase.domain.model.MoviesDto

class TopRatedUseCase {
    private val topRatedRepository = TopRatedRepositoryImpl()
    suspend fun invoke(): List<MoviesDto> {
        return topRatedRepository.getTopRatedRepository().map { topRatedMovieTable ->
            MoviesDto(
                topRatedMovieTable.id,
                topRatedMovieTable.adult,
                topRatedMovieTable.backdrop_path,
                topRatedMovieTable.original_language,
                topRatedMovieTable.original_title,
                topRatedMovieTable.overview,
                topRatedMovieTable.popularity,
                topRatedMovieTable.poster_path,
                topRatedMovieTable.release_date,
                topRatedMovieTable.title,
                topRatedMovieTable.video,
                topRatedMovieTable.vote_average,
                topRatedMovieTable.vote_count
            )
        }
    }
}