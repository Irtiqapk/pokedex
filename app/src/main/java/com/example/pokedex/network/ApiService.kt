package com.example.pokedex.network
import com.example.pokedex.model.DetailResponseModel
import com.example.pokedex.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemonData(): ResponseModel

    @GET
    suspend fun getPokemonDetails(@Url url: String): DetailResponseModel
}