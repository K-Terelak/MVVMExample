package com.example.mvvmexample.presentation.list

import com.example.mvvmexample.domain.model.DomainCharacter

data class ListScreenViewState(
    val characters: List<DomainCharacter> = emptyList()
)
