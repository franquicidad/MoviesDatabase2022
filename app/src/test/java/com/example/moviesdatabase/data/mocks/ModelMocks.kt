package com.example.moviesdatabase.data.mocks

import com.example.moviesdatabase.data.localDatasource.UpcomingMovieTable
import com.example.moviesdatabase.data.model.Movie
import com.example.moviesdatabase.data.model.MovieResponse
import com.example.moviesdatabase.domain.model.MoviesDto

object ModelMocks {

    fun getMovieResponse():MovieResponse{
        return MovieResponse(
            1,
            listOf(
                Movie(
                    adult = false,
                    backdrop_path = "rwwerwerwe.jpeg",
                    listOf(
                        1,2,3
                    ),
                    1123123,
                    original_language = "en,",
                    original_title = "Gol",
                    overview = "Great movie of Futbol",
                    popularity = 5.0,
                    poster_path = "werwerwer",
                    release_date = "1993-06-05",
                    title = "Gol",
                    video = false,
                    vote_average = 5.0,
                    vote_count = 5,
                )
            ),
            1000,
            1000,
        )
    }

    fun getListUpcomingTable(): List<UpcomingMovieTable>{
        return listOf( UpcomingMovieTable(
            0,
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
            vote_count = 5
        ))
    }

    fun getUpcomingMovieDto(): List<MoviesDto> {
        return listOf( UpcomingMovieTable(
            0,
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
            vote_count = 5
        )).map { upcomingMovieTable->
            MoviesDto(
                0,
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
                vote_count = 5
            )
        }
    }

    fun getMoviesDto(): MoviesDto{
        return MoviesDto(
            0,
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
            vote_count = 5
        )
    }
}