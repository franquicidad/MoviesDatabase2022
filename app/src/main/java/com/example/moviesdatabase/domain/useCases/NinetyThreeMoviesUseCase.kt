package com.example.moviesdatabase.domain.useCases

import com.example.moviesdatabase.data.repositories.ninetyThreeRepository.NinetyThreeRepository
import com.example.moviesdatabase.domain.model.MoviesDto
import javax.inject.Inject

class NinetyThreeMoviesUseCase @Inject constructor(
    private val ninetyThreeRepository: NinetyThreeRepository
) {
    suspend fun invoke():List<MoviesDto> {
        return ninetyThreeRepository.getNinetyThreeRepositoryMovies().map { ninetyThreeMoviesTable ->
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
