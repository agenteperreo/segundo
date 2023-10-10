package com.example.apliacininiciodesesion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apliacininiciodesesion.databinding.BienvenidaBinding

class ControlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bienvenidaVista = BienvenidaBinding.inflate(layoutInflater)

        val usuario = intent.getStringExtra("usuario")

        val password = intent.getStringExtra("password")

        var acceso = Intent(this, MainActivity::class.java)

        if (usuario == "usuario" && password == "usuario") {
            acceso = Intent(this, bienvenidaVista::class.java)
        }

        startActivity(acceso)

        finish()
    }
}