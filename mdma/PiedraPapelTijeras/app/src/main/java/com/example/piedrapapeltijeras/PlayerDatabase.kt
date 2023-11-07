package com.example.piedrapapeltijeras

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.piedrapapeltijeras.entidades.PlayerEntity

@Database(entities = arrayOf(PlayerEntity::class), version = 1)
abstract class PlayerDatabase :RoomDatabase() {
    abstract fun playerDao():PlayerDao
}