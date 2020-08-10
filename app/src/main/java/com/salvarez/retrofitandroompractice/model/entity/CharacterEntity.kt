package com.salvarez.retrofitandroompractice.model.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.salvarez.retrofitandroompractice.model.dto.Thumbnail

@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey
    var id: String,
    var name: String,
    var description: String,
    @Embedded
    var image: Thumbnail?,
    var score: Float?
)