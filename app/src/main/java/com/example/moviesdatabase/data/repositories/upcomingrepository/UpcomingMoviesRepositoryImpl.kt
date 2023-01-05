package com.example.moviesdatabase.data.repositories.upcomingrepository

import com.example.moviesdatabase.data.connectivityManager.otherConnectivityMethods.NetworkUtils
import com.example.moviesdatabase.data.localDatasource.UpcomingMovieTable
import com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource.UpcominglocalDatasource
import com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource.UpcomingRemoteDatasource
import javax.inject.Inject

class UpcomingMoviesRepositoryImpl @Inject constructor(
    private val upcominglocalDatasource: UpcominglocalDatasource,
    private val upcomingRemoteDatasource: UpcomingRemoteDatasource,
    private val networkUtils: NetworkUtils,
) : UpcomingMovieRepository {
    override suspend fun getUpcomingMoviesRepo(): List<UpcomingMovieTable> {
        if (networkUtils.hasNetworkAccess()) {
            if (upcominglocalDatasource.getUpcomingDatabaseMovies().isEmpty()) {
                val list = upcomingRemoteDatasource.getUpcomingMoviesRemoteDatasource()
                list.body()?.movies?.map { movie ->
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
                }?.let { upcominglocalDatasource.insertUpcomingDbMovies(it) }
                return upcominglocalDatasource.getUpcomingDatabaseMovies()
            } else {
                return upcominglocalDatasource.getUpcomingDatabaseMovies()
            }
        } else {
            return listOf()
        }


    }
}
