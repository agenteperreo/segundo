package com.example.primerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        Log.d(":::Tag", Elevado(3, 3))
    }

    private fun Elevado(numero : Int, exponente : Int) : String {

        var total: Double = numero.toDouble().pow(exponente.toDouble().toInt())
        return "El numero "+numero+" elevado a "+exponente+" es igual a "+total
    }
}