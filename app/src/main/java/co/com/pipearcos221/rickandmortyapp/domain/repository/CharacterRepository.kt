package co.com.pipearcos221.rickandmortyapp.domain.repository

import co.com.pipearcos221.rickandmortyapp.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): Result<List<Character>>
}
