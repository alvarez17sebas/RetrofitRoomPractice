package com.salvarez.retrofitandroompractice.viewmodel

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salvarez.retrofitandroompractice.di.LocalRepository
import com.salvarez.retrofitandroompractice.di.RemoteRepositoryQualifier
import com.salvarez.retrofitandroompractice.model.BaseResponse
import com.salvarez.retrofitandroompractice.model.data.RemoteRepository
import com.salvarez.retrofitandroompractice.model.data.Repository
import com.salvarez.retrofitandroompractice.model.data.RoomDatabaseRepository
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterViewModel @ViewModelInject constructor(@LocalRepository var localRepository: Repository<CharacterDto>, @RemoteRepositoryQualifier var remoteRepository: Repository<CharacterDto>): ViewModel() {

    //var remoteRepository: Repository<CharacterDto> = RemoteRepository()
    //@RemoteRepositoryQualifier
    //@Inject lateinit var remoteRepository: Repository<CharacterDto>
    //@Inject lateinit var localRepository: Repository<CharacterDto>

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