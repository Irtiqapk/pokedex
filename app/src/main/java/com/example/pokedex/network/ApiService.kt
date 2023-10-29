package com.example.pokedex.network
import com.example.pokedex.model.DetailResponseModel
import com.example.pokedex.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    // Pokemon List API
    @GET("pokemon")
    suspend fun getPokemonData(): ResponseModel

    // Pokemon Detail API
    @GET
    suspend fun getPokemonDetails(@Url url: String): DetailResponseModel
}