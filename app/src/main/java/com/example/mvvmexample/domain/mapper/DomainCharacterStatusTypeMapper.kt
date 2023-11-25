package com.example.mvvmexample.domain.mapper

import com.example.mvvmexample.domain.model.DomainCharacterStatusType
import javax.inject.Inject

class DomainCharacterStatusTypeMapper @Inject constructor() {
    operator fun invoke(status: String?) = when (status) {
        ALIVE -> DomainCharacterStatusType.ALIVE
        DEAD -> DomainCharacterStatusType.DEAD
        else -> DomainCharacterStatusType.UNKNOWN
    }

    private companion object {
        const val ALIVE = "Alive"
        const val DEAD = "Dead"
    }
}
