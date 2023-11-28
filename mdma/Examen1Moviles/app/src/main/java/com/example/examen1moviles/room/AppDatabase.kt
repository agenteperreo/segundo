package com.example.examen1moviles.room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.examen1moviles.MainActivity

@Database(entities = arrayOf(ClientesEntity::class, ConfiguraciónEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao():ExamenDao

    companion object {
        fun getInstance(mainActivity: Context): AppDatabase {
            return mainActivity.applicationContext.let {
                androidx.room.Room.databaseBuilder(
                    it,
                    AppDatabase::class.java,
                    "Examen-BBD"
                ).build()
            }
        }
    }
}