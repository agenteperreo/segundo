package com.example.ppt_room.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class UsuarioEntity(
    @PrimaryKey()
    val nick: String,
    val password: String,
    var partidasJugadas: Int,
    var maxPuntuacion: Int
    )