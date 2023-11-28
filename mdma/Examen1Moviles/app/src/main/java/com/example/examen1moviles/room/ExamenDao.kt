package com.example.examen1moviles.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExamenDao {

    @Update
    suspend fun updateConfiguration(configuracion:ConfiguraciónEntity)  // Sentencia para actualizar la tabla de configuración

    @Query("SELECT * FROM configuracion")     // Sentencia para obtener la cantidad de asientos por sala
    suspend fun getAsientos():MutableList<ConfiguraciónEntity>

    @Query("SELECT numSalas FROM configuracion")    // Sentencia para obtener la cantidad de salas del cine
    suspend fun getSalas():Int

    @Query("SELECT salaElegida FROM clientes") // Sentencia para obtener la sala elegida por el cliente
    suspend fun getSala():Int

    @Insert
    suspend fun insertCliente(clientesEntity: ClientesEntity) // Sentencia para  añadir un cliente a ClientesEntity

}