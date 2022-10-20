package com.example.moviesdatabase.domain.useCases

import com.example.moviesdatabase.data.repositories.ninetyThreeRepository.NinetyThreeRepositoryImpl
import com.example.moviesdatabase.domain.model.MoviesDto

class NinetyThreeMoviesUseCase {
    private val ninetyThreeRepositoryImpl=NinetyThreeRepositoryImpl()
    suspend fun invoke():List<MoviesDto> {
        return ninetyThreeRepositoryImpl.getNinetyThreeRepositoryMovies().map { ninetyThreeMoviesTable ->
        MoviesDto(
            ninetyThreeMoviesTable.id,
            ninetyThreeMoviesTable.adult,
            ninetyThreeMoviesTable.backdrop_path,
            ninetyThreeMoviesTable.original_language,
            ninetyThreeMoviesTable.original_title,
            ninetyThreeMoviesTable.overview,
            ninetyThreeMoviesTable.popularity,
            ninetyThreeMoviesTable.poster_path,
            ninetyThreeMoviesTable.release_date,
            ninetyThreeMoviesTable.title,
            ninetyThreeMoviesTable.video,
            ninetyThreeMoviesTable.vote_average,
            ninetyThreeMoviesTable.vote_count
        )

        }
    }
}