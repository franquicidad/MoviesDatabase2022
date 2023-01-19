package com.example.data.api

import com.example.moviesdatabase.data.model.Cast
import com.example.moviesdatabase.data.model.MovieResponse
import com.example.moviesdatabase.data.model.SimilarMoviesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    companion object API {
        const val API_KEY = "7d51874568317dfd0c91db399be2bdec"
        const val URL_FIRST =
            "https://api.themoviedb.org/3/movie/popular?api_key=7d51874568317dfd0c91db399be2bdec&language=en-US"
        const val UPCOMING =
            "https://api.themoviedb.org/3/movie/upcoming?api_key=7d51874568317dfd0c91db399be2bdec&language=en-ESP"
        const val TOPRATED =
            "https://api.themoviedb.org/3/movie/top_rated?api_key=7d51874568317dfd0c91db399be2bdec&language=en-US"
        const val ninetyThree =
            "https://api.themoviedb.org/3/discover/movie?api_key=7d51874568317dfd0c91db399be2bdec&primary_release_year=1993"
    }

    @GET("discover/movie")
    suspend fun getYearNinetyThreeMovies(
        @Query("api_key") api_key: String?,
        @Query("primary_release_year") byYear: String?,
    ): Response<MovieResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") api_key: String?,
        @Query("with_genres") genre: Int? = null,
        @Query("page") page: Int? = 1,
    ): Response<MovieResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") api_key: String?,
    ): Response<MovieResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") api_key: String?,
    ): Response<MovieResponse>

    @GET("movie/popular")
    suspend fun getSpanishMovies(
        @Query("api_key") api_key: String?,
        @Query("language") language: String?,
    ): Response<MovieResponse>

    @GET("{movie}/{movie_id}/credits")
    suspend fun getActorsByMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String,
    ): Cast

    @GET("{movie}/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int?,
    ): SimilarMoviesResponse
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
val service = retrofit.create(MovieService::class.java)
