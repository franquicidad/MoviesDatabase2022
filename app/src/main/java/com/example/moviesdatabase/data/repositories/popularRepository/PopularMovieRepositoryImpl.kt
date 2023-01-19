package com.example.moviesdatabase.data.repositories.popularRepository

import com.example.moviesdatabase.data.localDatasource.PopularTable
import com.example.moviesdatabase.data.localDatasource.popularMoviesLocalDatasource.PopularLocalDatasource
import com.example.moviesdatabase.data.remoteDatasource.popularMovies.PopularMoviesRemoteDatasource
import javax.inject.Inject

class PopularMovieRepositoryImpl @Inject constructor(
    private val remotePopularMoviesRemoteDatasource: PopularMoviesRemoteDatasource,
    private val popularLocalDatasource: PopularLocalDatasource,
) : PopularMovieRepository {
    override suspend fun getPopularMoviesRepository(): List<PopularTable> {
        if (popularLocalDatasource.getPopularMoviesDatabaseMovies().isEmpty()) {
            val popularList = remotePopularMoviesRemoteDatasource.getRemotePopularMovies()
            popularList.body()?.movies?.map { popularMovie ->
                PopularTable(
                    popularMovie.id,
                    popularMovie.adult,
                    popularMovie.backdrop_path,
                    popularMovie.original_language,
                    popularMovie.original_title,
                    popularMovie.overview,
                    popularMovie.popularity,
                    popularMovie.poster_path,
                    popularMovie.release_date,
                    popularMovie.title,
                    popularMovie.video,
                    popularMovie.vote_average,
                    popularMovie.vote_count
                )
            }?.let { popularTableList ->
                popularLocalDatasource.insertPopularMovies(popularTableList)
            }
            return popularLocalDatasource.getPopularMoviesDatabaseMovies()
        }
        return popularLocalDatasource.getPopularMoviesDatabaseMovies()
    }
}