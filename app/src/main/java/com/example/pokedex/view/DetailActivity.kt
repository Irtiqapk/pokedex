package com.example.pokedex.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pokedex.model.DetailResponseModel
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.viewmodel.PokemonDetailViewModel

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
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(0.dp, 8.dp)
        ) {
            Text(text = "Name: ", fontWeight = FontWeight.Bold)
            Text(text = pokemonDetailResponseModel.name.capitalize())
        }
        Column(
            modifier = Modifier.padding(0.dp, 8.dp)
        ) {

            Text(text = "Weight: ", fontWeight = FontWeight.Bold)
            Text(text = pokemonDetailResponseModel.weight.toString())
        }
        Column(
            modifier = Modifier.padding(0.dp, 8.dp)
        ) {

            Text(text = "Height: ", fontWeight = FontWeight.Bold)
            Text(text = pokemonDetailResponseModel.height.toString())
        }
    }


}



