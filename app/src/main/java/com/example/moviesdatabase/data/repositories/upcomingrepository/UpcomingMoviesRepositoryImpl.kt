package com.example.moviesdatabase.data.repositories.upcomingrepository

import android.util.Log
import com.example.moviesdatabase.data.localDatasource.UpcomingMovieTable
import com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource.UpcominglocalDatasource
import com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource.UpcomingRemoteDatasource
import javax.inject.Inject

class UpcomingMoviesRepositoryImpl @Inject constructor(
    private val upcominglocalDatasource: UpcominglocalDatasource,
    private val upcomingRemoteDatasource: UpcomingRemoteDatasource,
): UpcomingMovieRepository {
    override suspend fun getUpcomingMoviesRepo(): List<UpcomingMovieTable> {
        if (upcominglocalDatasource.getUpcomingDatabaseMovies().isEmpty()) {
            val list = upcomingRemoteDatasource.getUpcomingMoviesRemoteDatasource()
            upcominglocalDatasource.insertUpcomingDbMovies(list.movies.map { movie ->
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
            return upcominglocalDatasource.getUpcomingDatabaseMovies()
        } else {
            return upcominglocalDatasource.getUpcomingDatabaseMovies()
        }


    }
}
