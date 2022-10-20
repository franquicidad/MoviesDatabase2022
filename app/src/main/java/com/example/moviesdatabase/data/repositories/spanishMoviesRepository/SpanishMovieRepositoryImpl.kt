package com.example.moviesdatabase.data.repositories.spanishMoviesRepository

import com.example.moviesdatabase.data.localDatasource.SpanishTable
import com.example.moviesdatabase.data.localDatasource.spanishLocalDatasource.SpanishLocalDatasourceImpl
import com.example.moviesdatabase.data.remoteDatasource.getSpanishMoviesRemoteDatasource.SpanishMoviesRemoteDatasourceImpl

class SpanishMovieRepositoryImpl:SpanishMovieRepository {
    private val spanishMovieLocalDatasourceImpl =SpanishLocalDatasourceImpl()
    private val spanishMovieRemoteDatasourceImpl =SpanishMoviesRemoteDatasourceImpl()
    override suspend fun getSpanishMoviesRepository(): List<SpanishTable> {
        if (spanishMovieLocalDatasourceImpl.getSpanishDatabaseMovies().isEmpty()) {
            val list = spanishMovieRemoteDatasourceImpl.getSpanishMoviesRemoteDatasource()
            spanishMovieLocalDatasourceImpl.insertSpanishDbMovies(list.movies.map { movie ->
                SpanishTable(
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
            return spanishMovieLocalDatasourceImpl.getSpanishDatabaseMovies()
        } else {
            return spanishMovieLocalDatasourceImpl.getSpanishDatabaseMovies()
        }
    }
}