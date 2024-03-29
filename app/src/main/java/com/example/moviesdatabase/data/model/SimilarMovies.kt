package com.example.moviesdatabase.data.model

import com.google.gson.annotations.SerializedName

data class SimilarMovies(
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("original_name")
    val originalName: String?,
    val totalPages: Int?,
    val id: Int?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val title: String?,
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("vote_average")
    val rating: Double?,

    )