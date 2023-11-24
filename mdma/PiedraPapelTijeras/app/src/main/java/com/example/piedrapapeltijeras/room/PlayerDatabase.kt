package com.example.piedrapapeltijeras.room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.piedrapapeltijeras.MainActivity

@Database(entities = arrayOf(PlayerEntity::class), version = 1, exportSchema = false)
abstract class PlayerDatabase : RoomDatabase() {
    abstract fun PlayerDao():PlayerDao

    companion object {
        fun getInstance(mainActivity: Context): PlayerDatabase {
            return mainActivity.applicationContext.let {
                androidx.room.Room.databaseBuilder(
                    it,
                    PlayerDatabase::class.java,
                    "PPT-BD"
                ).build()
            }
        }
    }
}