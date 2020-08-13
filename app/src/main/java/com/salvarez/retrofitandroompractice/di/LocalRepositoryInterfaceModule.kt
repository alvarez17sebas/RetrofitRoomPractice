package com.salvarez.retrofitandroompractice.di

import com.salvarez.retrofitandroompractice.model.data.Repository
import com.salvarez.retrofitandroompractice.model.data.RoomDatabaseRepository
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class LocalRepositoryInterfaceModule {
    @Binds
    abstract fun provideLocalRepository(room: RoomDatabaseRepository): Repository<CharacterDto>
}