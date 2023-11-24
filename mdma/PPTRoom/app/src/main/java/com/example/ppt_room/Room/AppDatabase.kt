package com.example.ppt_room.Room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(UsuarioEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao

    companion object {
        fun getInstance(mainActivity: Context): AppDatabase {
            return mainActivity.applicationContext.let {
                androidx.room.Room.databaseBuilder(
                    it,
                    AppDatabase::class.java,
                    "PPT-BBDD"
                ).build()
            }

        }
    }
}
