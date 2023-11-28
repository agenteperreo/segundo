package com.example.whatsappfirebase.firebase

data class UserEntity(
    val idUsuario: Int,
    val mensaje: String,
    val correo: String,
    val nombre: String,
    val contrasena: String,
    val fotoUrl: String
) {
    constructor() : this(0, "","","","","")
}