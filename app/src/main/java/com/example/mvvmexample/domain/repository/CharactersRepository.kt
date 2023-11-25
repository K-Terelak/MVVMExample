package com.example.mvvmexample.domain.repository

import com.example.mvvmexample.data.Resource
import com.example.mvvmexample.domain.model.DomainCharacter

interface CharactersRepository {
    suspend fun getRemoteCharacters(): Resource<List<DomainCharacter>>
}
