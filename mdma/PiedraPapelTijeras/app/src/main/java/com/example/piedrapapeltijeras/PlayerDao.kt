package com.example.piedrapapeltijeras

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.piedrapapeltijeras.entidades.PlayerEntity

@Dao
interface PlayerDao {
    @Query("SELECT * FROM player")
    suspend fun getAllTasks(): MutableList<PlayerEntity>  // Función que devuelve todas las tareas de la base de datos en una lista Mutable.

    @Insert
    suspend fun addTask(playerEntity: PlayerEntity):Long    // Función que añade una tarea, la que se pasa por parámetro, y devuelve el id insertado.                                                          // Devuelve Long porque la cantidad de datos guardada puede ser muy alto.

    @Query("SELECT * FROM Player where nombre like :nombre")
    suspend fun getTaskById(nombre: String): PlayerEntity        // Función que busca tareas por id (debe ser Long, no Int)

    @Update
    suspend fun updateTask(player: PlayerEntity):Int         // Función que actualiza una tarea y devuelve

    @Delete
    suspend fun deleteTask(player: PlayerEntity):Int         // Función que borra una tarea y devuelve
}