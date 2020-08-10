package com.salvarez.retrofitandroompractice.model.data.database

import androidx.room.*
import com.salvarez.retrofitandroompractice.model.entity.CharacterEntity

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(data: CharacterEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(dataList: MutableList<CharacterEntity>)

    @Update
    suspend fun update(data: CharacterEntity)

    @Query("SELECT * FROM character")
    suspend fun getAll(): MutableList<CharacterEntity>

    @Query("SELECT * FROM character WHERE id = :id")
    suspend fun getById(id: String): MutableList<CharacterEntity>

    @Delete
    suspend fun delete(data: CharacterEntity)
}