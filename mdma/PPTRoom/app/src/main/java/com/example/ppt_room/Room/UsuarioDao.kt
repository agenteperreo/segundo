package com.example.ppt_room.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsuarioDao {
    @Insert
    suspend fun insertUserStats(usuarioEntity: UsuarioEntity)

    @Update
    suspend fun updateUserStats(usuarioEntity: UsuarioEntity)

    @Query("SELECT * FROM usuario WHERE nick = :nick")
    suspend fun getUserStatsByNick(nick: String): UsuarioEntity

    @Query("SELECT * FROM usuario ORDER BY maxPuntuacion DESC")
    suspend fun getAllUserStats(): MutableList<UsuarioEntity>

    //obten un usuario con el nick y la contraseña
    @Query("SELECT * FROM usuario WHERE nick = :nick AND password = :password")
    suspend fun getUser(nick: String, password: String): UsuarioEntity

    //obten un usuario con el nick
    @Query("SELECT * FROM usuario WHERE nick = :nick")
    suspend fun getUserByUsername(nick: String): UsuarioEntity
}