package com.salvarez.retrofitandroompractice.di

import com.salvarez.retrofitandroompractice.model.data.RemoteRepository
import com.salvarez.retrofitandroompractice.model.data.Repository
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object RemoteRepositoryModuleDeprecated {

    @Provides
    fun provideRemoteRepository() : Repository<CharacterDto>{
        return RemoteRepository()
    }
}