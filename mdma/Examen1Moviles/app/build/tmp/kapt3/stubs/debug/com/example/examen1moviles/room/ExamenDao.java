package com.example.examen1moviles.room;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/examen1moviles/room/ExamenDao;", "", "getAsientos", "", "Lcom/example/examen1moviles/room/Configuraci\u00f3nEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSala", "", "Id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSalas", "insertCliente", "", "clientesEntity", "Lcom/example/examen1moviles/room/ClientesEntity;", "(Lcom/example/examen1moviles/room/ClientesEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConfiguration", "configuracion", "(Lcom/example/examen1moviles/room/Configuraci\u00f3nEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ExamenDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateConfiguration(@org.jetbrains.annotations.NotNull
    com.example.examen1moviles.room.ConfiguraciónEntity configuracion, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM configuracion")
    public abstract java.lang.Object getAsientos(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.examen1moviles.room.ConfiguraciónEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT numSalas FROM configuracion")
    public abstract java.lang.Object getSalas(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT salaElegida FROM clientes WHERE id = :Id")
    public abstract java.lang.Object getSala(int Id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert
    public abstract java.lang.Object insertCliente(@org.jetbrains.annotations.NotNull
    com.example.examen1moviles.room.ClientesEntity clientesEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}