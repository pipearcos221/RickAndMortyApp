package co.com.pipearcos221.rickandmortyapp.presentation.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.com.pipearcos221.rickandmortyapp.data.remote.api.NetworkModule
import co.com.pipearcos221.rickandmortyapp.data.repository.CharacterRepositoryImpl

class CharacterViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            val apiService = NetworkModule.provideRickAndMortyApiService()
            val repository = CharacterRepositoryImpl(apiService)
            @Suppress("UNCHECKED_CAST")
            return CharacterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
