package com.salvarez.retrofitandroompractice.model.data

import com.salvarez.retrofitandroompractice.model.BaseResponse
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteRepository @Inject constructor(): Repository<CharacterDto> {

    private var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    private var marvelService: MarvelService = retrofit.create(MarvelService::class.java)

    override suspend fun save(data: CharacterDto) {
        var response = BaseResponse<Boolean>()
        response.data = true

    }

    override suspend fun update(data: CharacterDto) {
        var response = BaseResponse<Boolean>()
        response.data = true
    }

    override suspend fun getAll(): MutableList<CharacterDto> {
        val response = marvelService.getAllCharacters()
        return response.data.results
    }

    override suspend fun getById(id: String): MutableList<CharacterDto> {
        var baseResponse: BaseResponse<MutableList<CharacterDto>> = BaseResponse()
        baseResponse.data = marvelService.getCharactersById(id)
        return marvelService.getCharactersById(id)
    }

    override suspend fun saveAll(dataList: MutableList<CharacterDto>) {
    }


}