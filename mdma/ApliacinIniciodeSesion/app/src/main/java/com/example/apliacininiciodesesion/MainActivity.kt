package com.example.apliacininiciodesesion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apliacininiciodesesion.databinding.ActivityMainBinding
import com.example.apliacininiciodesesion.databinding.BienvenidaBinding
import com.example.apliacininiciodesesion.databinding.PausaBinding

class MainActivity : AppCompatActivity() {

    var nombre = ""

    var pausa = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMain = ActivityMainBinding.inflate(layoutInflater)

        val bienvenida = BienvenidaBinding.inflate(layoutInflater)

        setContentView(activityMain.root)

        var boton = activityMain.btnLogin

        boton.setOnClickListener {
            nombre = activityMain.txtUsuarioInput.text.toString()
            setContentView(bienvenida.root)
            bienvenida.txtBienvenida.text = "Nos alegramos de que vuelvas, $nombre"
        }
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(applicationContext, "He parado", Toast.LENGTH_SHORT).show()

        val pausa = PausaBinding.inflate(layoutInflater)

        setContentView(pausa.root)
    }
    override fun onResume() {
        super.onResume()

        Toast.makeText(applicationContext, "Bienvenido de nuevo $nombre", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()


    }
}