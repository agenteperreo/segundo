package com.example.piedrapapeltijeras.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PlayerDao {

    @Insert
    suspend fun insertPlayerStats(playerEntity:PlayerEntity)

    @Update
    suspend fun updatePlayerStats(playerEntity: PlayerEntity)

    @Query("SELECT * FROM jugadores WHERE nombre = :nombre")
    suspend fun getPlayerStatsByName(nombre:String):PlayerEntity

    @Query("SELECT * FROM jugadores ORDER BY maxPuntuacion DESC")
    suspend fun getAllPlayesStats():MutableList<PlayerEntity>

    @Query("SELECT * FROM jugadores WHERE nombre = :nombre and contraseña = :contraseña")
    suspend fun getPlayer(nombre: String, contraseña:String):PlayerEntity



}