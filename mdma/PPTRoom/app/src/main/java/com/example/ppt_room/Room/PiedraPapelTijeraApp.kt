package com.example.ppt_room.Room
import android.app.Application
import androidx.room.Room

class PiedraPapelTijeraApp:Application(){
    companion object {
        lateinit var database: AppDatabase
    }
    override fun onCreate() {
        super.onCreate()
        PiedraPapelTijeraApp.database =  Room.databaseBuilder(this, AppDatabase::class.java, "PPT-BBD").build()
    }
}