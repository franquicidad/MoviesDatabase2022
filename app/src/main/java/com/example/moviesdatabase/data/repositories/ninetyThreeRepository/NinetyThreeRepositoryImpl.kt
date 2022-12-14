package com.example.moviesdatabase.data.repositories.ninetyThreeRepository

import android.util.Log
import com.example.moviesdatabase.data.localDatasource.NinetyThreeMoviesTable
import com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource.NinetyThreeLocalDatasource
import com.example.moviesdatabase.data.remoteDatasource.ninetyThreeRemoteDatasource.NinetyThreeRemoteDatasource
import javax.inject.Inject

class NinetyThreeRepositoryImpl @Inject constructor(
    private val ninetyThreeLocalDatasource: NinetyThreeLocalDatasource,
    private val ninetyThreeRemoteDatasource: NinetyThreeRemoteDatasource,
) : NinetyThreeRepository {
    override suspend fun getNinetyThreeRepositoryMovies(): List<NinetyThreeMoviesTable> {
        if (ninetyThreeLocalDatasource.getNinetyThreeDatabaseMovies().isEmpty() ||
            ninetyThreeLocalDatasource.getNinetyThreeDatabaseMovies().size < 6
        ) {
            val list = ninetyThreeRemoteDatasource.getNinetyThreeRemoteDatasource()
            list.body()?.movies?.map { movie ->
                NinetyThreeMoviesTable(
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
            }?.let { ninetyThreeLocalDatasource.insertNinetyThreeDbMovies(it) }
            val roomList = ninetyThreeLocalDatasource.getNinetyThreeDatabaseMovies()
            Log.i("RoomList", roomList.size.toString())

            return ninetyThreeLocalDatasource.getNinetyThreeDatabaseMovies()
        } else {
            return ninetyThreeLocalDatasource.getNinetyThreeDatabaseMovies()
        }
    }
}
