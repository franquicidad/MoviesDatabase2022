package com.example.moviesdatabase.data.repositories.upcomingrepository

import com.example.moviesdatabase.data.localDatasource.UpcomingMovieTable
import com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource.UpcomingLocalDatasourceImpl
import com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource.UpcomingRemoteDatasourceImpl
import com.example.moviesdatabase.domain.model.MoviesDto

class UpcomingMoviesRepositoryImpl: UpcomingMovieRepository {
    private val upcomingLocalDatasource = UpcomingLocalDatasourceImpl()
    private val upcomingRemoteDatasourceImpl = UpcomingRemoteDatasourceImpl()
    override suspend fun getUpcomingMoviesRepo(): List<UpcomingMovieTable> {
        if (upcomingLocalDatasource.getUpcomingDatabaseMovies().isEmpty()) {
            val list = upcomingRemoteDatasourceImpl.getUpcomingMoviesRemoteDatasource()
            upcomingLocalDatasource.insertUpcomingDbMovies(list.movies.map { movie ->
                UpcomingMovieTable(
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
            return upcomingLocalDatasource.getUpcomingDatabaseMovies()
        } else {
            return upcomingLocalDatasource.getUpcomingDatabaseMovies()
        }
    }
}