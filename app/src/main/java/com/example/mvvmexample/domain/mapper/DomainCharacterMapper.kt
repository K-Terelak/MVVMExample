package com.example.mvvmexample.domain.mapper

import com.example.mvvmexample.data.remote.model.response.Result
import com.example.mvvmexample.domain.model.DomainCharacter
import javax.inject.Inject

// Mapper (mapuje obiekt zwracany z api na obiekt domenowy)
class DomainCharacterMapper @Inject constructor(
    private val domainCharacterGenderTypeMapper: DomainCharacterGenderTypeMapper,
    private val domainCharacterStatusTypeMapper: DomainCharacterStatusTypeMapper
) {

    operator fun invoke(character: Result): DomainCharacter = with(character) {
        DomainCharacter(
            id = id,
            name = name,
            gender = domainCharacterGenderTypeMapper(gender), // Mapowanie "stringa" na określony w celu łatwiejszego obsługiwania
            image = image,
            species = species,
            status = domainCharacterStatusTypeMapper(status),
            type = type,
            count = 0 // dodałem pole count (odpowiada za opcje plus/minus dla kazdego elementu listy)
        )
    }
}
