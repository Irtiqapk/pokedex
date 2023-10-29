package com.example.pokedex

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokedex.model.DetailResponseModel
import com.example.pokedex.model.PokemonItem
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.view.OnItemClickListener
import com.example.pokedex.view.PokemonItem
import com.example.pokedex.viewmodel.PokemonDetailViewModel
import com.example.pokedex.viewmodel.PokemonViewModel

class DetailActivity : ComponentActivity() {
    val pokemonDetailViewModel by viewModels<PokemonDetailViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokemonDetail(pokemonDetailViewModel.pokemonDetailResponseModel)
                    val apiUrl = intent.getStringExtra("DetailUrl")!!
                    pokemonDetailViewModel.getPokemonDetails(apiUrl)


                }
            }
        }
    }
}

@Composable
fun PokemonDetail(pokemonDetailResponseModel: DetailResponseModel) {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = pokemonDetailResponseModel.height.toString(), modifier = Modifier.weight(.8f))
    }


}



