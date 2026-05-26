package co.com.pipearcos221.rickandmortyapp.data.remote.api

import co.com.pipearcos221.rickandmortyapp.data.remote.dto.CharacterResponse
import retrofit2.http.GET

interface RickAndMortyApiService {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}
