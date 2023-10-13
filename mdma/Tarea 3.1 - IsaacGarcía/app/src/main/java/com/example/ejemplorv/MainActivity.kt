package com.example.ejemplorv

import android.content.Intent
import android.net.Uri
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
                Contacto("Juan Antonio Fernandez Guerrero", "123456", "H"),
                Contacto("María Palacios Sanchez", "678456123", "M"),
                Contacto("Raúl Gamero Valiente", "644789456", "H"),
                Contacto("Raúl", "644789456", "H"),
                Contacto("Raúl", "644789456", "M"),
                Contacto("Raúl", "644789456", "M"),
                Contacto("Raúl", "644789456", "M"),
                Contacto("Raúl", "644789456", "M"),
                Contacto("Raúl", "644789456", "H"),
                Contacto("Raúl", "644789456", "H"),
                Contacto("Raúl", "644789456", "M"),
                Contacto("Raúl", "644789456", "H"),
                Contacto("Raúl", "644789456", "H"),
                Contacto("Raúl", "644789456", "M")
            ), object : ContactoPulsadorListener {
                override fun contactoPulsado(contacto: Contacto) {
                    val dial = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contacto.tlfno))
                    startActivity(dial)
                }
            }
        )
    }
}