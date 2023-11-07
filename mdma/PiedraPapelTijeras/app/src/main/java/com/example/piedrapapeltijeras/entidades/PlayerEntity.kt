package com.example.piedrapapeltijeras.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Player")
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var nombre:String = "",
    var numPartJug:Int = 0,
    var racha3Derrotas:Int = 0
)