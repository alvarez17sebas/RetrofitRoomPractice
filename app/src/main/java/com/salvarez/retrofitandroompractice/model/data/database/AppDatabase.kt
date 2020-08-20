package com.salvarez.retrofitandroompractice.model.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salvarez.retrofitandroompractice.model.entity.CharacterEntity


@Database(entities = [CharacterEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

}