package com.example.room_prueba

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.room_prueba.entidades.TaskEntity

@Database(entities = arrayOf(TaskEntity::class), version = 1)
abstract class TasksDatabase :RoomDatabase() {
    abstract fun taskDao():TaskDao
}