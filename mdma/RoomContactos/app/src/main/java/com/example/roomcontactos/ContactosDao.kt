package com.example.roomcontactos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Query("SELECT * FROM contactos_entity")
    suspend fun getAllContacts(): MutableList<Contacto>  // Función que devuelve todos los contactos de la base de datos en una lista Mutable.

    @Insert
    suspend fun addContact(taskEntity :Contacto):Long    // Función que añade un contacto, la que se pasa por parámetro, y devuelve el id insertado.                                                          // Devuelve Long porque la cantidad de datos guardada puede ser muy alto.

    @Query("SELECT * FROM contactos_entity where id like :id")
    suspend fun getContactById(id: Long):Contacto        // Función que busca contactos por id (debe ser Long, no Int)

    @Update
    suspend fun updateContact(task:Contacto):Int         // Función que actualiza un contacto y devuelve

    @Delete
    suspend fun deleteContact(task:Contacto):Int         // Función que borra un contacto y devuelve
}