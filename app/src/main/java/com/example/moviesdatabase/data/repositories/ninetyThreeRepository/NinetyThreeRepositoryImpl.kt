package com.example.moviesdatabase.data.repositories.ninetyThreeRepository

import com.example.moviesdatabase.data.localDatasource.NinetyThreeMoviesTable
import com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource.NinetyThreeLocalDatasource
import com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource.NinetyThreeLocalDatasourceImpl
import com.example.moviesdatabase.data.remoteDatasource.ninetyThreeRemoteDatasource.NinetyThreeRemoteDatasource
import com.example.moviesdatabase.data.remoteDatasource.ninetyThreeRemoteDatasource.NinetythreeRemoteDatasourceImpl
import javax.inject.Inject

class NinetyThreeRepositoryImpl @Inject constructor(
    private val ninetyThreeLocalDatasource: NinetyThreeLocalDatasource,
    private val ninetyThreeRemoteDatasource: NinetyThreeRemoteDatasource
) :NinetyThreeRepository {
    override suspend fun getNinetyThreeRepositoryMovies(): List<NinetyThreeMoviesTable> {
        if (ninetyThreeLocalDatasource.getNinetyThreeDatabaseMovies().isEmpty()) {
            val list = ninetyThreeRemoteDatasource.getNinetyThreeRemoteDatasource()
            ninetyThreeLocalDatasource.insertNinetyThreeDbMovies(list.movies.map { movie ->
                NinetyThreeMoviesTable(
                    movie.id,
                    movie.adult,
                    movie.backdrop_path,
                    movie.original_language,
                    movie.original_title,
                    movie.overview,
                    movie.popularity,
                    movie.poster_path,
                    movie.release_date,
                    movie.title,
                    movie.video,
                    movie.vote_average,
                    movie.vote_count,
                )
            })
            return ninetyThreeLocalDatasource.getNinetyThreeDatabaseMovies()
        } else {
            return ninetyThreeLocalDatasource.getNinetyThreeDatabaseMovies()
        }
    }
}