package com.salvarez.retrofitandroompractice.model.mapping

import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import com.salvarez.retrofitandroompractice.model.entity.CharacterEntity

class CharacterMapping {

    companion object{

        fun toCharacterEntity(characterDto: CharacterDto): CharacterEntity{
            return CharacterEntity(characterDto.id, characterDto.name, characterDto.description, characterDto.image, characterDto.score)
        }

        fun toCharacterDto(characterEntity: CharacterEntity): CharacterDto{
            return CharacterDto(characterEntity.id, characterEntity.name, characterEntity.description, characterEntity.image!!, characterEntity.score!!)
        }

        fun toListCharacterEntity(characterDtoList: MutableList<CharacterDto>): MutableList<CharacterEntity>{

            val list: MutableList<CharacterEntity> = ArrayList()
            characterDtoList.forEach {
                val characterEntity = toCharacterEntity(it)
                list.add(characterEntity)
            }
            return list
        }

        fun toListCharacterDto(characterEntityList: MutableList<CharacterEntity>): MutableList<CharacterDto>{
            val list: MutableList<CharacterDto> = ArrayList()
            characterEntityList.forEach {
                val characterEntity = toCharacterDto(it)
                list.add(characterEntity)
            }
            return list
        }

    }

}