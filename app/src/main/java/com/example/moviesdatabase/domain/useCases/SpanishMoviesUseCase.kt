package com.example.moviesdatabase.domain.useCases

import com.example.moviesdatabase.data.repositories.spanishMoviesRepository.SpanishMovieRepository
import com.example.moviesdatabase.domain.model.MoviesDto
import javax.inject.Inject

class SpanishMoviesUseCase @Inject constructor(
    private val spanishMovieRepository: SpanishMovieRepository
) {
    suspend fun invoke(): List<MoviesDto>{
        return spanishMovieRepository.getSpanishMoviesRepository().map { spanishTable ->
            MoviesDto(
                spanishTable.id,
                spanishTable.adult,
                spanishTable.backdrop_path,
                spanishTable.original_language,
                spanishTable.original_title,
                spanishTable.overview,
                spanishTable.popularity,
                spanishTable.poster_path,
                spanishTable.release_date,
                spanishTable.title,
                spanishTable.video,
                spanishTable.vote_average,
                spanishTable.vote_count
            )
        }
    }
}
