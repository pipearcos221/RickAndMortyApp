package co.com.pipearcos221.rickandmortyapp.presentation.character_list

import co.com.pipearcos221.rickandmortyapp.domain.model.Character
import co.com.pipearcos221.rickandmortyapp.domain.repository.CharacterRepository
import co.com.pipearcos221.rickandmortyapp.util.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CharacterViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val repository: CharacterRepository = mockk()
    private lateinit var viewModel: CharacterViewModel

    @Test
    fun `fetchCharacters success updates uiState to Success`() = runTest {
        // Given
        val characters = listOf(
            Character(1, "Rick", "Alive", "url"),
            Character(2, "Morty", "Alive", "url")
        )
        coEvery { repository.getCharacters() } returns Result.success(characters)

        // When
        viewModel = CharacterViewModel(repository)

        // Then
        val state = viewModel.uiState.value
        assertTrue(state is CharacterUiState.Success)
        assertEquals(characters, (state as CharacterUiState.Success).characters)
    }

    @Test
    fun `fetchCharacters failure updates uiState to Error`() = runTest {
        // Given
        val errorMessage = "Network Error"
        coEvery { repository.getCharacters() } returns Result.failure(Exception(errorMessage))

        // When
        viewModel = CharacterViewModel(repository)

        // Then
        val state = viewModel.uiState.value
        assertTrue(state is CharacterUiState.Error)
        assertEquals(errorMessage, (state as CharacterUiState.Error).message)
    }
}
