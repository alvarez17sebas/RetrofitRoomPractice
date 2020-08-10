package com.salvarez.retrofitandroompractice.model.data

import android.content.Context
import com.salvarez.retrofitandroompractice.model.BaseResponse
import com.salvarez.retrofitandroompractice.model.data.database.AppDatabase
import com.salvarez.retrofitandroompractice.model.data.database.CharacterDao
import com.salvarez.retrofitandroompractice.model.entity.CharacterEntity
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import com.salvarez.retrofitandroompractice.model.mapping.CharacterMapping

class RoomDatabaseRepository(context: Context) : Repository<CharacterDto> {

    private var roomDatabase: AppDatabase? = AppDatabase.getInstance(context)
    private var characterDao:CharacterDao? = roomDatabase?.characterDao()

    override suspend fun save(data: CharacterDto){
        val characterEntity: CharacterEntity = CharacterMapping.toCharacterEntity(data)
        //return characterDao!!.save(characterEntity)
    }

    override suspend fun update(data: CharacterDto) {
        val characterEntity: CharacterEntity = CharacterMapping.toCharacterEntity(data)
        characterDao?.update(characterEntity)
    }

    override suspend fun getAll(): MutableList<CharacterDto> {
        val responseEntity: MutableList<CharacterEntity> = characterDao!!.getAll()
        return CharacterMapping.toListCharacterDto(responseEntity)
    }

    override suspend fun getById(id: String): MutableList<CharacterDto>{
        val responseEntity: MutableList<CharacterEntity> = characterDao!!.getById(id)
        return CharacterMapping.toListCharacterDto(responseEntity)
    }

    override suspend fun saveAll(dataList: MutableList<CharacterDto>) {
        val characterEntity: MutableList<CharacterEntity> = CharacterMapping.toListCharacterEntity(dataList)
        characterDao?.saveAll(characterEntity)
    }


}