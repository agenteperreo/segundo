package com.example.examen1moviles.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clientes")
data class ClientesEntity(
    @PrimaryKey()
    val Id:Long,
    val salaElegida:Int = 0,
    val palomitas:Int
)