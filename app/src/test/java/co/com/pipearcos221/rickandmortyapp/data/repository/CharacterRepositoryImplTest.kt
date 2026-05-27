package co.com.pipearcos221.rickandmortyapp.data.repository

import co.com.pipearcos221.rickandmortyapp.data.remote.api.RickAndMortyApiService
import co.com.pipearcos221.rickandmortyapp.data.remote.dto.CharacterDto
import co.com.pipearcos221.rickandmortyapp.data.remote.dto.CharacterResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CharacterRepositoryImplTest {

    private val apiService: RickAndMortyApiService = mockk()
    private val repository = CharacterRepositoryImpl(apiService)

    @Test
    fun `getCharacters success returns success result with mapped characters`() = runTest {
        // Given
        val dtos = listOf(
            CharacterDto(1, "Rick", "Alive", "url1"),
            CharacterDto(2, "Morty", "Alive", "url2")
        )
        val response = CharacterResponse(dtos)
        coEvery { apiService.getCharacters() } returns response

        // When
        val result = repository.getCharacters()

        // Then
        assertTrue(result.isSuccess)
        val characters = result.getOrNull()!!
        assertEquals(2, characters.size)
        assertEquals("Rick", characters[0].name)
        assertEquals("url1", characters[0].imageUrl)
        assertEquals("Morty", characters[1].name)
        assertEquals("url2", characters[1].imageUrl)
    }

    @Test
    fun `getCharacters failure returns failure result`() = runTest {
        // Given
        val errorMessage = "API Error"
        coEvery { apiService.getCharacters() } throws RuntimeException(errorMessage)

        // When
        val result = repository.getCharacters()

        // Then
        assertTrue(result.isFailure)
        assertEquals(errorMessage, result.exceptionOrNull()?.message)
    }
}
