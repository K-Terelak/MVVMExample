package com.example.mvvmexample.di

import com.example.mvvmexample.data.remote.RemoteCharactersDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    // Dostarczanie data source'a
    @Singleton
    @Provides
    fun provideRemoteCharactersDataSource(retrofit: Retrofit): RemoteCharactersDataSource =
        retrofit.create(RemoteCharactersDataSource::class.java)
}
