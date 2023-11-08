package com.example.piedrapapeltijeras

import android.app.Application
import androidx.room.Room

class PPTApp:Application() {
    companion object {
        lateinit var database: PlayerDatabase
    }

    override fun onCreate() {
        super.onCreate()
        PPTApp.database = Room.databaseBuilder(this, PlayerDatabase::class.java, "players-db").build()
    }
}