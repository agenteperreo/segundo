package com.example.primerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.primerproyecto.databinding.ActivityMainBinding
import com.example.primerproyecto.databinding.OtraVistaBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val otraVista = OtraVistaBinding.inflate(layoutInflater)
        val activityMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(otraVista.root)

        var boton = otraVista.patras

        boton.setOnClickListener {
            Toast.makeText(applicationContext, "Me has pulsado", Toast.LENGTH_SHORT).show()
        }
        /*otraVista.patras.setOnClickListener() {
            setContentView(ActivityMain.root)
        }*/
    }

}