package com.example.moviesdatabase.data.localDatasource

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ninety_three")
data class NinetyThreeMoviesTable (
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int?,

    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdrop_path: String?,
    @SerializedName("original_language")
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    @SerializedName("title")
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
)
