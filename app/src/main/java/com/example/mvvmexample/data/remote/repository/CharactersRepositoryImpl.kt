package com.example.mvvmexample.data.remote.repository

import android.util.Log
import com.example.mvvmexample.data.Resource
import com.example.mvvmexample.data.remote.RemoteCharactersDataSource
import com.example.mvvmexample.domain.mapper.DomainCharacterMapper
import com.example.mvvmexample.domain.model.DomainCharacter
import com.example.mvvmexample.domain.repository.CharactersRepository
import javax.inject.Inject

// IMplementacja repozytorum (zawiera logike)
class CharactersRepositoryImpl @Inject constructor(
    private val remoteCharactersDataSource: RemoteCharactersDataSource,
    private val domainCharacterMapper: DomainCharacterMapper
) : CharactersRepository {


    override suspend fun getRemoteCharacters(): Resource<List<DomainCharacter>> {
        try {
            val response = remoteCharactersDataSource.getRemoteCharacters()

            if (response.isSuccessful) {
                response.body()?.let { charactersResponse ->
                    return Resource.Success(
                        data = charactersResponse.results?.map(domainCharacterMapper::invoke)
                    )
                }
            }
            Log.e(
                "CharactersRepositoryImpl",
                "getRemoteCharacters: error code - ${response.code()}"
            )
            return Resource.Error("Something went wrong. Try again later!")
        } catch (e: Exception) {
            Log.e("CharactersRepositoryImpl", "getRemoteCharacters: $e")
            return Resource.Error("Something went wrong. Try again later!")
        }
    }
}

