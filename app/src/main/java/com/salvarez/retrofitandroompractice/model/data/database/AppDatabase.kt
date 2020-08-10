package com.salvarez.retrofitandroompractice.model.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.salvarez.retrofitandroompractice.model.entity.CharacterEntity


@Database(entities = [CharacterEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase?{

            val tmpInstance = INSTANCE
            if(INSTANCE != null){
                return tmpInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "roomretrofit_db")
                    .addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                return INSTANCE
            }
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                val query: String = "ALTER TABLE character ADD COLUMN score FLOAT DEFAULT 0"
                database.execSQL(query)
            }

        }

    }
}