package com.example.moviesdatabase.di.repos

import com.example.moviesdatabase.data.connectivityManager.otherConnectivityMethods.NetworkUtils
import com.example.moviesdatabase.data.connectivityManager.otherConnectivityMethods.NetworkUtilsImpl
import com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource.NinetyThreeLocalDatasource
import com.example.moviesdatabase.data.localDatasource.ninetyThreeLocalDatasource.NinetyThreeLocalDatasourceImpl
import com.example.moviesdatabase.data.localDatasource.popularMoviesLocalDatasource.PopularLocalDatasource
import com.example.moviesdatabase.data.localDatasource.popularMoviesLocalDatasource.PopularLocalDatasourceImpl
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
import com.example.moviesdatabase.data.remoteDatasource.popularMovies.PopularMoviesRemoteDatasource
import com.example.moviesdatabase.data.remoteDatasource.popularMovies.PopularMoviesRemoteDatasourceImpl
import com.example.moviesdatabase.data.remoteDatasource.topRatedRemoteDatasource.TopRatedRemoteDatasource
import com.example.moviesdatabase.data.remoteDatasource.topRatedRemoteDatasource.TopRatedRemoteDatasourceImpl
import com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource.UpcomingRemoteDatasource
import com.example.moviesdatabase.data.remoteDatasource.upcomingRemoteDatasource.UpcomingRemoteDatasourceImpl
import com.example.moviesdatabase.data.repositories.ninetyThreeRepository.NinetyThreeRepository
import com.example.moviesdatabase.data.repositories.ninetyThreeRepository.NinetyThreeRepositoryImpl
import com.example.moviesdatabase.data.repositories.popularRepository.PopularMovieRepository
import com.example.moviesdatabase.data.repositories.popularRepository.PopularMovieRepositoryImpl
import com.example.moviesdatabase.data.repositories.spanishMoviesRepository.SpanishMovieRepository
import com.example.moviesdatabase.data.repositories.spanishMoviesRepository.SpanishMovieRepositoryImpl
import com.example.moviesdatabase.data.repositories.topRatedRepository.TopRatedRepository
import com.example.moviesdatabase.data.repositories.topRatedRepository.TopRatedRepositoryImpl
import com.example.moviesdatabase.data.repositories.upcomingrepository.UpcomingMovieRepository
import com.example.moviesdatabase.data.repositories.upcomingrepository.UpcomingMoviesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepoModule {

    @Singleton
    @Binds
    abstract fun provideUpcomingRepo(
        upcomingMoviesRepositoryImpl: UpcomingMoviesRepositoryImpl,
    ): UpcomingMovieRepository

    @Singleton
    @Binds
    abstract fun provideTopRatedRepo(
        topRatedRepositoryImpl: TopRatedRepositoryImpl,
    ): TopRatedRepository

    @Singleton
    @Binds
    abstract fun provideSpanishRepo(
        spanishRepositoryImpl: SpanishMovieRepositoryImpl,
    ): SpanishMovieRepository

    @Singleton
    @Binds
    abstract fun provideNinetyRepo(
        ninetyThreeRepositoryImpl: NinetyThreeRepositoryImpl,
    ): NinetyThreeRepository

    @Singleton
    @Binds
    abstract fun providePopularRepo(
        popularMovieRepositoryImpl: PopularMovieRepositoryImpl,
    ): PopularMovieRepository

    @Singleton
    @Binds
    abstract fun provideUpcomingLocalDatasource(
        upcomingLocalDatasourceImpl: UpcomingLocalDatasourceImpl,
    ): UpcominglocalDatasource

    @Singleton
    @Binds
    abstract fun providePopularLocalDatasource(
        popularLocalDatasourceImpl: PopularLocalDatasourceImpl,
    ): PopularLocalDatasource

    @Singleton
    @Binds
    abstract fun providePopularRemoteDatasource(
        remotePopularMoviesRemoteDatasourceImpl: PopularMoviesRemoteDatasourceImpl,
    ): PopularMoviesRemoteDatasource

    @Singleton
    @Binds
    abstract fun provideUpcomingRemoteDatasource(
        upcomingRemoteDatasource: UpcomingRemoteDatasourceImpl,
    ): UpcomingRemoteDatasource

    @Singleton
    @Binds
    abstract fun topRatedRemoteDatasource(
        topRatedRemoteDatasource: TopRatedRemoteDatasourceImpl,
    ): TopRatedRemoteDatasource

    @Singleton
    @Binds
    abstract fun topRatedLocalDatasource(
        topRatedLocalDatasource: TopRatedLocalDatasourceImpl,
    ): TopRatedLocalDatasource

    @Singleton
    @Binds
    abstract fun spanishRemoteDatasource(
        spanishRemoteDatasource: SpanishMoviesRemoteDatasourceImpl,
    ): SpanishMoviesRemoteDatasource

    @Singleton
    @Binds
    abstract fun spanishLocalDatasource(
        spanishLocalDatasource: SpanishLocalDatasourceImpl,
    ): SpanishLocalDatasource

    @Singleton
    @Binds
    abstract fun ninetyThreeLocalDatasource(
        ninetyThreeLocalDatasourceImpl: NinetyThreeLocalDatasourceImpl,
    ): NinetyThreeLocalDatasource

    @Singleton
    @Binds
    abstract fun ninetyThreeRemoteDatasource(
        ninetyThreeRemoteDatasourceImpl: NinetythreeRemoteDatasourceImpl,
    ): NinetyThreeRemoteDatasource

    @Singleton
    @Binds
    abstract fun networkUtils(
        networkUtilsImpl: NetworkUtilsImpl,
    ): NetworkUtils

}