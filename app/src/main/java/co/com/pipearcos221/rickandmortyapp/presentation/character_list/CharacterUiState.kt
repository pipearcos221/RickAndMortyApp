package co.com.pipearcos221.rickandmortyapp.presentation.character_list

import co.com.pipearcos221.rickandmortyapp.domain.model.Character

sealed interface CharacterUiState {
    object Loading : CharacterUiState
    data class Success(val characters: List<Character>) : CharacterUiState
    data class Error(val message: String) : CharacterUiState
}
