package com.salvarez.retrofitandroompractice.model.dto

import com.google.gson.annotations.SerializedName


data class CharacterDto(
    var id: String,
    var name: String,
    var description: String,
    @SerializedName("thumbnail")
    var image: Thumbnail,
    var score: Float
)