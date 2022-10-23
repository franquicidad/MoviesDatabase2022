package com.example.moviesdatabase.upcomingLocalDatasource.mockTable

import com.example.moviesdatabase.data.localDatasource.UpcomingMovieTable

object MockDaos {

    fun getUpcomingMovieTable(): List<UpcomingMovieTable> {
        return listOf( UpcomingMovieTable(
            1,
            adult = false,
            backdrop_path = "werwfsdf",
            original_language = "en",
            original_title = "Fly",
            overview = "This is a movie to fly",
            popularity = 5.0,
            poster_path = "dfsdfsdf.jpeg",
            release_date = "1993-05-06",
            title = "Fly",
            video = false,
            vote_average = 5.0,
            vote_count = 5,
        ))
    }
}