package com.example.mvvmexample.presentation.list

import com.example.mvvmexample.domain.model.DomainCharacter

// ViewState - dane które będą wyświetlane na widok
data class ListScreenViewState(
    val characters: List<DomainCharacter> = emptyList()
)
