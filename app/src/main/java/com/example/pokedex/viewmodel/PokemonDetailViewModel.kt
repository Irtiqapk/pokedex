package com.example.pokedex.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.model.DetailResponseModel
import com.example.pokedex.network.RetrofitInstance
import com.example.pokedex.model.PokemonItem
import kotlinx.coroutines.launch

class PokemonDetailViewModel : ViewModel() {
    private val apiService = RetrofitInstance.apiService
    var pokemonDetailResponseModel: DetailResponseModel by mutableStateOf(DetailResponseModel())
    var errorMessage: String by mutableStateOf("")
    fun getPokemonDetails(url:String) {
        viewModelScope.launch {
            try {
                pokemonDetailResponseModel = apiService.getPokemonDetails(url)
            } catch (e: Exception) {
                // Handle errors
                errorMessage = e.message.toString()
            }
        }
    }
}