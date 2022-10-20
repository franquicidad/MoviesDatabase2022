package com.example.moviesdatabase.data.repositories.topRatedRepository

import com.example.moviesdatabase.data.localDatasource.TopRatedTable
import com.example.moviesdatabase.data.localDatasource.topRatedLocalDatasource.TopRatedLocalDatasourceImpl
import com.example.moviesdatabase.data.remoteDatasource.topRatedRemoteDatasource.TopRatedRemoteDatasourceImpl

class TopRatedRepositoryImpl:TopRatedRepository {
    override suspend fun getTopRatedRepository(): List<TopRatedTable> {
        val topRatedLocalDatasource = TopRatedLocalDatasourceImpl()
        val topRatedRemoteDatasourceImpl = TopRatedRemoteDatasourceImpl()
        if (topRatedLocalDatasource.getTopRatedDatabaseMovies().isEmpty()) {
            val list = topRatedRemoteDatasourceImpl.getTopRatedMoviesRemoteDatasource()
            topRatedLocalDatasource.insertTopRatedDbMovies(list.movies.map { movie ->
                TopRatedTable(
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
            return topRatedLocalDatasource.getTopRatedDatabaseMovies()
        } else {
            return topRatedLocalDatasource.getTopRatedDatabaseMovies()
        }
    }
}