package com.example.roomcontactos

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity que alamacenará los contactos de la lista
@Entity(tableName = "contactos_entity")
data class Contacto(
    // Primary key es la id del contacto
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    // Nombre del contacto
    var name:String= "",

    //Telefono del contacto
    var telf:String = "",

    //Genero del contacto
    var genero:String = ""
)