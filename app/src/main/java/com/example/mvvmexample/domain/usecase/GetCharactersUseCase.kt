package com.example.mvvmexample.domain.usecase

import com.example.mvvmexample.data.Resource
import com.example.mvvmexample.domain.model.DomainCharacter
import com.example.mvvmexample.domain.repository.CharactersRepository
import javax.inject.Inject

// UseCase - w tym przypadku niepotrzebny bo nic nie dodaje 'nowego'
// ALe ogolnie w tym miejscu możemy dodać jakąć dodatkową logikę (np: dodanie do listy jakiegoś nooweo itemu)
class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    suspend operator fun invoke(): Resource<List<DomainCharacter>> =
        charactersRepository.getRemoteCharacters()
}
