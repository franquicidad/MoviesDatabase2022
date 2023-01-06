package com.example.moviesdatabase.data.repositories.topRatedRepository

import com.example.moviesdatabase.data.localDatasource.TopRatedTable
import com.example.moviesdatabase.data.localDatasource.topRatedLocalDatasource.TopRatedLocalDatasource
import com.example.moviesdatabase.data.remoteDatasource.topRatedRemoteDatasource.TopRatedRemoteDatasource
import com.example.moviesdatabase.util.NetworkUtils
import javax.inject.Inject

class TopRatedRepositoryImpl @Inject constructor(
    private val topRatedLocalDatasource: TopRatedLocalDatasource,
    private val topRatedRemoteDatasource: TopRatedRemoteDatasource,
    private val networkUtils: NetworkUtils,
) : TopRatedRepository {
    override suspend fun getTopRatedRepository(): List<TopRatedTable> {
        if (topRatedLocalDatasource.getTopRatedDatabaseMovies().isEmpty()) {
            val list = topRatedRemoteDatasource.getTopRatedMoviesRemoteDatasource()
            list.body()?.movies?.map { movie ->
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
            }?.let { listTopRated ->
                topRatedLocalDatasource.insertTopRatedDbMovies(listTopRated)
            }
            return topRatedLocalDatasource.getTopRatedDatabaseMovies()
        } else {
            return topRatedLocalDatasource.getTopRatedDatabaseMovies()
        }
    }
}

