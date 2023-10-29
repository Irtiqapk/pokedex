package com.example.pokedex.model

data class DetailResponseModel(
    val id: Int = 0,
    val name: String = "",
    val sprites: Sprites = Sprites(),
    val types: List<Type> = emptyList(),
    val height: Int = 0,
    val weight: Int = 0
)