package com.salvarez.retrofitandroompractice.di

import com.salvarez.retrofitandroompractice.model.data.Repository
import com.salvarez.retrofitandroompractice.model.data.RoomDatabaseRepository
import com.salvarez.retrofitandroompractice.model.data.database.CharacterDao
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent

//@InstallIn(ActivityRetainedComponent::class)
//@Module
object LocalRepositoryModule {
    //@Provides
    fun provideLocalRepository(characterDao: CharacterDao): Repository<CharacterDto> {
        return RoomDatabaseRepository(characterDao)
    }
}