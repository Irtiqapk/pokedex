package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokedex.model.PokemonItem
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.view.PokemonItem
import com.example.pokedex.viewmodel.PokemonViewModel

class MainActivity : ComponentActivity() {

    val pokemonViewModel by viewModels<PokemonViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokemonList(pokemonList = pokemonViewModel.pokemonListResponse)
                    pokemonViewModel.loadData()
                }
            }
        }
    }
}

@Composable
fun PokemonList(pokemonList: List<PokemonItem>){
    LazyColumn{
        itemsIndexed(items = pokemonList){
            index, item ->
            PokemonItem(data = item)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokedexTheme {
        Greeting("Android")
    }
}
