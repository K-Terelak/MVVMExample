package com.example.mvvmexample.domain.mapper

import com.example.mvvmexample.domain.model.DomainCharacterStatusType
import javax.inject.Inject

// Mapowanie danych z api na obiekt domenowy
class DomainCharacterStatusTypeMapper @Inject constructor() {

    // api zawraca typ: "ALive" lub "Dead"
    // Dodaliśmy 3. typ UNKNOWN
    // Przydatne jeśli na backendzie dodadza jakis inny typ ktorego nasza aplikacja 'jeszcze' nie wspiera
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
