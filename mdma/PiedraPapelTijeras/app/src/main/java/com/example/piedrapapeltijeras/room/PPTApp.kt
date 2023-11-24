package com.example.piedrapapeltijeras.room

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase

class PPTApp:Application() {
    companion object {
        lateinit var database: PlayerDatabase
    }

    override fun onCreate() {
        super.onCreate()
        PPTApp.database = Room.databaseBuilder(this, PlayerDatabase::class.java, "PPT-BD").build()
    }
}