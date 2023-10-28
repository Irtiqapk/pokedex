package com.example.pokedex.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.RetrofitInstance
import com.example.pokedex.model.PokemonItem
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val apiService = RetrofitInstance.apiService
    var pokemonListResponse:List<PokemonItem> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun loadData() {
        viewModelScope.launch {
            try {
                pokemonListResponse = apiService.getPokemonData().results
            } catch (e: Exception) {
                // Handle errors
                errorMessage = e.message. toString()
            }
        }
    }
}