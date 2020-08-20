package com.salvarez.retrofitandroompractice.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salvarez.retrofitandroompractice.di.LocalRepository
import com.salvarez.retrofitandroompractice.di.RemoteRepositoryQualifier
import com.salvarez.retrofitandroompractice.model.data.Repository
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel @ViewModelInject constructor(@LocalRepository var localRepository: Repository<CharacterDto>, @RemoteRepositoryQualifier var remoteRepository: Repository<CharacterDto>): ViewModel() {

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