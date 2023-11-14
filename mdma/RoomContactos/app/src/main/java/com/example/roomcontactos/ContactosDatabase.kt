package com.example.roomcontactos

import androidx.room.Database
import androidx.room.RoomDatabase

// Creamos la base de datos con un array de contactos
@Database(entities = arrayOf(Contacto::class), version = 1)

// Creamos la clase abstracta de tipo RoomDatabase
abstract class ContactsDatabase : RoomDatabase() {

    // Creamos la funcion abstracta
    abstract fun ContactsDao():TaskDao
}