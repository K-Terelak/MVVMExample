package com.example.mvvmexample.domain.mapper

import com.example.mvvmexample.data.remote.model.response.Result
import com.example.mvvmexample.domain.model.DomainCharacter
import javax.inject.Inject

class DomainCharacterMapper @Inject constructor(
    private val domainCharacterGenderTypeMapper: DomainCharacterGenderTypeMapper,
    private val domainCharacterStatusTypeMapper: DomainCharacterStatusTypeMapper
) {

    operator fun invoke(character: Result): DomainCharacter = with(character) {
        DomainCharacter(
            id = id,
            name = name,
            gender = domainCharacterGenderTypeMapper(gender),
            image = image,
            species = species,
            status = domainCharacterStatusTypeMapper(status),
            type = type,
            count = 0
        )
    }
}
