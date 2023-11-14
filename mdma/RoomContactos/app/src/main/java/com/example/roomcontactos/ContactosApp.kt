package com.example.roomcontactos

import android.app.Application
import androidx.room.Room

class ContactosApp: Application() {
    companion object {
        lateinit var database: ContactsDatabase
    }

    override fun onCreate() {
        super.onCreate()
        ContactosApp.database = Room.databaseBuilder(this, ContactsDatabase::class.java, "contactos-db").build()
    }
}