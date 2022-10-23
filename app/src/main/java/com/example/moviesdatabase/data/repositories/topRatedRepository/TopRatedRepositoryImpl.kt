package com.example.moviesdatabase.data.repositories.topRatedRepository

import com.example.moviesdatabase.data.localDatasource.TopRatedTable
import com.example.moviesdatabase.data.localDatasource.topRatedLocalDatasource.TopRatedLocalDatasource
import com.example.moviesdatabase.data.remoteDatasource.topRatedRemoteDatasource.TopRatedRemoteDatasource
import javax.inject.Inject

class TopRatedRepositoryImpl @Inject constructor(
    private val topRatedLocalDatasource: TopRatedLocalDatasource,
    private val topRatedRemoteDatasource: TopRatedRemoteDatasource
):TopRatedRepository {
    override suspend fun getTopRatedRepository(): List<TopRatedTable> {
        if (topRatedLocalDatasource.getTopRatedDatabaseMovies().isEmpty()) {
            val list = topRatedRemoteDatasource.getTopRatedMoviesRemoteDatasource()
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
