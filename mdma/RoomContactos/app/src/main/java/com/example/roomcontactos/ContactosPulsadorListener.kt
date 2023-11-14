package com.example.roomcontactos

// Interfaz para la pulsación del contacto
interface ContactosPulsadorListener {

    // Función para la pulsación del contacto
    fun contactoPulsado(contacto: Contacto) {}
}