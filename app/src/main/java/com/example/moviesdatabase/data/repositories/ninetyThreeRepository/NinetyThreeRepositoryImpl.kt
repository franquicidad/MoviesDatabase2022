package com.example.moviesdatabase.data.repositories.ninetyThreeRepository

import com.example.moviesdatabase.data.localDatasource.NinetyThreeMoviesTable
import com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource.NinetyThreeLocalDatasourceImpl
import com.example.moviesdatabase.data.remoteDatasource.ninetyThreeRemoteDatasource.NinetythreeRemoteDatasourceImpl

class NinetyThreeRepositoryImpl :NinetyThreeRepository {
    private val ninetyThreeLocalDatasourceImpl = NinetyThreeLocalDatasourceImpl()
    private val ninetythreeRemoteDatasourceImpl = NinetythreeRemoteDatasourceImpl()
    override suspend fun getNinetyThreeRepositoryMovies(): List<NinetyThreeMoviesTable> {
        if (ninetyThreeLocalDatasourceImpl.getNinetyThreeDatabaseMovies().isEmpty()) {
            val list = ninetythreeRemoteDatasourceImpl.getNinetyThreeRemoteDatasource()
            ninetyThreeLocalDatasourceImpl.insertNinetyThreeDbMovies(list.movies.map { movie ->
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
            return ninetyThreeLocalDatasourceImpl.getNinetyThreeDatabaseMovies()
        } else {
            return ninetyThreeLocalDatasourceImpl.getNinetyThreeDatabaseMovies()
        }
    }
}