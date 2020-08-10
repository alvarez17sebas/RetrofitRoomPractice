package com.salvarez.retrofitandroompractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.salvarez.retrofitandroompractice.model.BaseResponse
import com.salvarez.retrofitandroompractice.model.data.RemoteRepository
import com.salvarez.retrofitandroompractice.model.data.Repository
import com.salvarez.retrofitandroompractice.model.data.RoomDatabaseRepository
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel(application: Application) : AndroidViewModel(application) {

    var remoteRepository: Repository<CharacterDto> = RemoteRepository()
    var localRepository: Repository<CharacterDto> = RoomDatabaseRepository(application.applicationContext)

     var characterList: MutableLiveData<MutableList<CharacterDto>> = MutableLiveData()


    fun getAllCharacters(){

       viewModelScope.launch {

            var response: MutableList<CharacterDto>? = null

            withContext(Dispatchers.IO){

                response = localRepository.getAll()

                if(response?.size == 0){
                    response = remoteRepository.getAll()
                    localRepository.saveAll(response!!)
                }
            }
            characterList.value = response
        }
    }

}