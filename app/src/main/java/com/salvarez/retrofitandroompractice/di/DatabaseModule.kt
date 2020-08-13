package com.salvarez.retrofitandroompractice.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.salvarez.retrofitandroompractice.model.data.Repository
import com.salvarez.retrofitandroompractice.model.data.RoomDatabaseRepository
import com.salvarez.retrofitandroompractice.model.data.database.AppDatabase
import com.salvarez.retrofitandroompractice.model.data.database.CharacterDao
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun getInstance(@ApplicationContext context: Context): AppDatabase{
        synchronized(this){
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "roomretrofit_db")
                .addMigrations(MIGRATION_1_2)
                .build()
        }

    }

    private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            val query: String = "ALTER TABLE character ADD COLUMN score FLOAT DEFAULT 0"
            database.execSQL(query)
        }

    }

    @Provides
    fun provideCharacterDao(database: AppDatabase): CharacterDao{
        return database.characterDao()
    }

}