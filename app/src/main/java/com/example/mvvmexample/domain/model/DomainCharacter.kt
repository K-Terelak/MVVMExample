package com.example.mvvmexample.domain.model

// Model domenowy
data class DomainCharacter(
    val id: Int?,
    val name: String?,
    val gender: DomainCharacterGenderType,
    val image: String?,
    val species: String?,
    val status: DomainCharacterStatusType,
    val type: String?,
    val count: Int // dodatkowy parametry ktory nie przychodzi z api
)
