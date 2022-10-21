package com.example.moviesdatabase.data.repositories.spanishMoviesRepository

import com.example.moviesdatabase.data.localDatasource.SpanishTable
import com.example.moviesdatabase.data.localDatasource.spanishLocalDatasource.SpanishLocalDatasource
import com.example.moviesdatabase.data.remoteDatasource.getSpanishMoviesRemoteDatasource.SpanishMoviesRemoteDatasource
import javax.inject.Inject

class SpanishMovieRepositoryImpl @Inject constructor(
    private val spanishMovieLocalDatasource: SpanishLocalDatasource,
    private val spanishMoviesRemoteDatasource: SpanishMoviesRemoteDatasource
):SpanishMovieRepository {
    override suspend fun getSpanishMoviesRepository(): List<SpanishTable> {
        if (spanishMovieLocalDatasource.getSpanishDatabaseMovies().isEmpty()) {
            val list = spanishMoviesRemoteDatasource.getSpanishMoviesRemoteDatasource()
            spanishMovieLocalDatasource.insertSpanishDbMovies(list.movies.map { movie ->
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
            return spanishMovieLocalDatasource.getSpanishDatabaseMovies()
        } else {
            return spanishMovieLocalDatasource.getSpanishDatabaseMovies()
        }
    }
}