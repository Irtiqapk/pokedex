package com.example.pokedex.model

data class ResponseModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PokemonItem>
)