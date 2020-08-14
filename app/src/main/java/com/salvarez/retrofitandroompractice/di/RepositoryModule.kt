package com.salvarez.retrofitandroompractice.di

import com.salvarez.retrofitandroompractice.model.data.RemoteRepository
import com.salvarez.retrofitandroompractice.model.data.Repository
import com.salvarez.retrofitandroompractice.model.data.RoomDatabaseRepository
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class RemoteRepositoryQualifier

@Qualifier
annotation class LocalRepository

@InstallIn(ApplicationComponent::class)
@Module
abstract class LocalRepositoryModule{
    @LocalRepository
    @Singleton
    @Binds
    abstract fun bindRoomDatabase(impl: RoomDatabaseRepository): Repository<CharacterDto>

}

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class RemoteRepositoryModule{
    @RemoteRepositoryQualifier
    @Binds
    abstract fun bindRoomDatabase(impl: RemoteRepository): Repository<CharacterDto>

}
