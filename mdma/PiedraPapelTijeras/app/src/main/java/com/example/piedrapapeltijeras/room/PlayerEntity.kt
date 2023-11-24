package com.example.piedrapapeltijeras.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jugadores")
data class PlayerEntity(
    @PrimaryKey()
    var nombre:String,
    var contraseña:String,
    var partidasJugadas:Int,
    var maxPuntuacion:Int
)