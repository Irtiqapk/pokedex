package com.example.pokedex.model

data class PokemonData(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PokemonItem>
)