package com.example.mvvmexample.presentation.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.domain.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    var viewState by mutableStateOf(ListScreenViewState())
        private set

    init {
        viewModelScope.launch(IO) {
            getCharactersUseCase().data?.let { characters ->
                withContext(Main) {
                    viewState = viewState.copy(characters = characters)
                }
            }
        }
    }

    fun changeColor(id: Int?, option: CountOptions) {
        val updatedCharacters = viewState.characters.map { character ->
            if (character.id == id) {
                val newCount = when (option) {
                    CountOptions.PLUS -> character.count.plus(1)
                    CountOptions.MINUS -> character.count.minus(1)
                }
                character.copy(count = newCount)
            } else {
                character
            }
        }

        viewState = viewState.copy(characters = updatedCharacters)
    }
}
