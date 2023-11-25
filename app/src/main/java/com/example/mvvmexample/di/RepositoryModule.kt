package com.example.mvvmexample.di

import com.example.mvvmexample.data.remote.RemoteCharactersDataSource
import com.example.mvvmexample.data.remote.repository.CharactersRepositoryImpl
import com.example.mvvmexample.domain.mapper.DomainCharacterMapper
import com.example.mvvmexample.domain.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharactersRepository(
        remoteCharactersDataSource: RemoteCharactersDataSource,
        domainCharacterMapper: DomainCharacterMapper
    ): CharactersRepository = CharactersRepositoryImpl(
        remoteCharactersDataSource = remoteCharactersDataSource,
        domainCharacterMapper = domainCharacterMapper
    )
}
