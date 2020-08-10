package com.salvarez.retrofitandroompractice.model.data

import com.salvarez.retrofitandroompractice.model.dto.BaseResponseMarvel
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import retrofit2.http.*

interface MarvelService {

    @GET("characters")
    suspend fun getAllCharacters(@Query("ts") ts: String? = "1",
        @Query("apikey") apiKey: String? = PUBLIC_KEY,
        @Query("hash") hash: String? = "d50e0881703f78b6f79e2c24be03afec"): BaseResponseMarvel

    @GET("characters/{id}")
    suspend fun getCharactersById(@Path("id") id: String): MutableList<CharacterDto>

}