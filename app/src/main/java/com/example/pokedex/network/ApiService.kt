package com.example.pokedex.network

import com.example.pokedex.model.PokemonData
import com.google.gson.JsonObject
import retrofit2.http.GET

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemonData(): PokemonData
}