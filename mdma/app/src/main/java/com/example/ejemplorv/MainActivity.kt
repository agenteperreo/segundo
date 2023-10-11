package com.example.ejemplorv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplorv.databinding.ActivityMainBinding
import com.example.ejemplorv.databinding.ContactosBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contactos = ContactosBinding.inflate(layoutInflater)
        setContentView(contactos.root)
        contactos.vistaContactos.adapter = ContactosAdapter(
            listOf(
                Contacto("Juan", "123456"),
                Contacto("María", "678456123"),
                Contacto("Raúl", "644789456"),
                Contacto("Raúl", "644789456"),
                Contacto("Raúl", "644789456"),
                Contacto("Raúl", "644789456"),
                Contacto("Raúl", "644789456"),
                Contacto("Raúl", "644789456"),
                Contacto("Raúl", "644789456"),
                Contacto("Raúl", "644789456"),
                Contacto("Raúl", "644789456"),
                Contacto("Raúl", "644789456"),
                Contacto("Raúl", "644789456"),
                Contacto("Raúl", "644789456"),
            )
        )
    }
}