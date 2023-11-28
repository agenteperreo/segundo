package com.example.whatsappfirebase.firebase

import java.sql.Timestamp

data class MessageEntity(
    val idMensaje: Int,
    val mensaje: String,
    val horayFecha: Timestamp,
    val idSender: Int,
    val idReceiver: Int,
    val recibido: Boolean,
    val visto: Boolean
) {
    constructor() : this(0,"", Timestamp(System.currentTimeMillis()), 0, 0, false, false)
}