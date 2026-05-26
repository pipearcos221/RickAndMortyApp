package co.com.pipearcos221.rickandmortyapp.presentation.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.pipearcos221.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<CharacterUiState>(CharacterUiState.Loading)
    val uiState: StateFlow<CharacterUiState> = _uiState.asStateFlow()

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            repository.getCharacters()
                .onSuccess { characters ->
                    _uiState.value = CharacterUiState.Success(characters)
                }
                .onFailure { exception ->
                    _uiState.value = CharacterUiState.Error(
                        message = exception.message ?: "An unknown error occurred"
                    )
                }
        }
    }

    fun retryFetch() {
        _uiState.value = CharacterUiState.Loading
        fetchCharacters()
    }
}
