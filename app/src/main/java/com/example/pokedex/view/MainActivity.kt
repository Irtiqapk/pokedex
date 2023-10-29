package com.example.pokedex.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.example.pokedex.viewmodel.PokemonViewModel

class MainActivity : ComponentActivity(), OnItemClickListener {

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
                    PokemonList(pokemonList = pokemonViewModel.pokemonListResponse, clickListener = this)
                    pokemonViewModel.getAllPokemons()
                }
            }
        }
    }

    override fun onItemClick(item: PokemonItem) {
        // Handle item click
        Log.e("IM", item.url)
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("DetailUrl",item.url)
        startActivity(intent)
    }
}

@Composable
fun PokemonList(pokemonList: List<PokemonItem>, clickListener: OnItemClickListener) {
    LazyColumn {
        itemsIndexed(items = pokemonList) { index, item ->
            PokemonItem(data = item, clickListener)
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
