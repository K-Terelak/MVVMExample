package com.example.mvvmexample.domain.mapper

import com.example.mvvmexample.domain.model.DomainCharacterGenderType
import javax.inject.Inject

class DomainCharacterGenderTypeMapper @Inject constructor() {
    operator fun invoke(gender: String?): DomainCharacterGenderType = when (gender) {
        MALE -> DomainCharacterGenderType.MALE
        FEMALE -> DomainCharacterGenderType.FEMALE
        GENDERLESS -> DomainCharacterGenderType.GENDERLESS
        else -> DomainCharacterGenderType.UNKNOWN
    }

    private companion object {
        const val MALE = "Male"
        const val FEMALE = "Female"
        const val GENDERLESS = "Genderless"
    }
}
