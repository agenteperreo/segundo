package com.example.examen1moviles.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "configuracion")
data class ConfiguraciónEntity (
    @PrimaryKey()
    val numSalas:Int = 0,
    val numAsientos:Int = 0,
    val precioPalomitas: Float = 0f
)