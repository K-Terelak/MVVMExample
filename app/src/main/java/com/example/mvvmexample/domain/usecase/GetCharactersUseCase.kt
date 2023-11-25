package com.example.mvvmexample.domain.usecase

import com.example.mvvmexample.data.Resource
import com.example.mvvmexample.domain.model.DomainCharacter
import com.example.mvvmexample.domain.repository.CharactersRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    suspend operator fun invoke(): Resource<List<DomainCharacter>> =
        charactersRepository.getRemoteCharacters()
}
