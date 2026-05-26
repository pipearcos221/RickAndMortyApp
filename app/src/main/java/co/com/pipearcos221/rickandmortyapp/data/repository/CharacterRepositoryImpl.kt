package co.com.pipearcos221.rickandmortyapp.data.repository

import co.com.pipearcos221.rickandmortyapp.data.remote.api.RickAndMortyApiService
import co.com.pipearcos221.rickandmortyapp.data.mapper.toDomain
import co.com.pipearcos221.rickandmortyapp.domain.model.Character
import co.com.pipearcos221.rickandmortyapp.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val apiService: RickAndMortyApiService
) : CharacterRepository {

    override suspend fun getCharacters(): Result<List<Character>> {
        return try {
            val response = apiService.getCharacters()
            val characters = response.results.map { it.toDomain() }
            Result.success(characters)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
