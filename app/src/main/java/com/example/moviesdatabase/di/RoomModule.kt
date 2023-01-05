package com.example.moviesdatabase.di

import com.example.data.api.MovieService
import com.example.moviesdatabase.data.localDatasource.MovieDatabase
import com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource.NinetyThreeLocalDatasource
import com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource.NinetyThreeLocalDatasourceImpl
import com.example.moviesdatabase.data.localDatasource.spanishLocalDatasource.SpanishLocalDatasource
import com.example.moviesdatabase.data.localDatasource.spanishLocalDatasource.SpanishLocalDatasourceImpl
import com.example.moviesdatabase.data.localDatasource.topRatedLocalDatasource.TopRatedLocalDatasource
import com.example.moviesdatabase.data.localDatasource.topRatedLocalDatasource.TopRatedLocalDatasourceImpl
import com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource.UpcomingLocalDatasourceImpl
import com.example.moviesdatabase.data.localDatasource.upcomingLocalDatasource.UpcominglocalDatasource
import com.example.moviesdatabase.data.remoteDatasource.getSpanishMoviesRemoteDatasource.SpanishMoviesRemoteDatasource
import com.example.moviesdatabase.data.remoteDatasource.getSpanishMoviesRemoteDatasource.SpanishMoviesRemoteDatasourceImpl
import com.example.moviesdatabase.data.remoteDatasource.ninetyThreeRemoteDatasource.NinetyThreeRemoteDatasource
import com.example.moviesdatabase.data.remoteDatasource.ninetyThreeRemoteDatasource.NinetythreeRemoteDatasourceImpl
import com.example.moviesdatabase.data.remoteDatasource.topRatedRemoteDatasource.TopRatedRemoteDatasource
import com.example.moviesdatabase.data.remoteDatasource.topRatedRemoteDatasource.TopRatedRemoteDatasourceImpl
import com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource.UpcomingRemoteDatasource
import com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource.UpcomingRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(
    ActivityComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideNinetyThreeLocalDatasource(
        room: MovieDatabase,
    ): NinetyThreeLocalDatasource {
        return NinetyThreeLocalDatasourceImpl(room)
    }

    @Singleton
    @Provides
    fun provideUpcomingLocalDatasource(
        room: MovieDatabase,
    ): UpcominglocalDatasource {
        return UpcomingLocalDatasourceImpl(room)
    }

    @Singleton
    @Provides
    fun provideTopRatedLocalDatasource(
        room: MovieDatabase,
    ): TopRatedLocalDatasource {
        return TopRatedLocalDatasourceImpl(room)
    }

    @Singleton
    @Provides
    fun provideSpanishLocalData(
        room: MovieDatabase,
    ): SpanishLocalDatasource {
        return SpanishLocalDatasourceImpl(room)
    }

    @Singleton
    @Provides
    fun provideUpcomingRemote(
        service: MovieService,
    ): UpcomingRemoteDatasource {
        return UpcomingRemoteDatasourceImpl(service)
    }

    @Singleton
    @Provides
    fun provideTopRatedRemote(
        service: MovieService,
    ): TopRatedRemoteDatasource {
        return TopRatedRemoteDatasourceImpl(service)
    }

    @Singleton
    @Provides
    fun provideSpanishRemote(
        service: MovieService,
    ): SpanishMoviesRemoteDatasource {
        return SpanishMoviesRemoteDatasourceImpl(service)
    }

    @Singleton
    @Provides
    fun provideNinetyRemote(
        service: MovieService,
    ): NinetyThreeRemoteDatasource {
        return NinetythreeRemoteDatasourceImpl(service)
    }

}