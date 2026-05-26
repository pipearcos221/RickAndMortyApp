package co.com.pipearcos221.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import co.com.pipearcos221.rickandmortyapp.presentation.character_list.CharacterListScreen
import co.com.pipearcos221.rickandmortyapp.presentation.character_list.CharacterViewModel
import co.com.pipearcos221.rickandmortyapp.presentation.character_list.CharacterViewModelFactory
import co.com.pipearcos221.rickandmortyapp.ui.theme.RickAndMortyAppTheme

class MainActivity : ComponentActivity() {
    
    private val viewModel: CharacterViewModel by viewModels { CharacterViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyAppTheme {
                CharacterListScreen(viewModel = viewModel)
            }
        }
    }
}
