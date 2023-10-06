package com.example.tarea22_isaacgarca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tarea22_isaacgarca.databinding.ActivityMainBinding
import com.example.tarea22_isaacgarca.databinding.CalculadoraBinding

class MainActivity : AppCompatActivity() {

    var contasena = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val main = ActivityMainBinding.inflate(layoutInflater)
        val calculadora = CalculadoraBinding.inflate(layoutInflater)

        setContentView(main.root)

        // Cuando pulsemos el boton de log in se comprueba que
        // la contraseña sea correcta y si o lo es mostramos un toast
        var boton = main.btnLogin

        boton.setOnClickListener {
            contasena = main.txtContraseAInput.text.toString()

            if(contasena.equals("abc123")) {
                setContentView(calculadora.root)
            } else {
                Toast.makeText(applicationContext, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        }

        // Cuando pulsemos el boton de sumar comprobará si algun
        // valor está vacio, y si está vacio, se pone a 0 y se muestra el resultado
        var sumar = calculadora.btnSumar

        sumar.setOnClickListener {
            var num1 = calculadora.inputNum1.text.toString()
            var num2 = calculadora.inputNum2.text.toString()
            var aux1 = 0.0
            var aux2 = 0.0

            if(num1.isNotEmpty()) {
                aux1 = num1.toDouble()
            }
            if(num2.isNotEmpty()) {
                aux2 = num2.toDouble()
            }

            var resulado = aux1+aux2
            calculadora.txtResFinal.text = ""+resulado
        }

        // Cuando pulsemos el boton de restar comprobará si algun
        // valor está vacio, y si está vacio, se pone a 0 y se muestra el resultado
        var restar = calculadora.btnRestar

        restar.setOnClickListener {
            var num1 = calculadora.inputNum1.text.toString()
            var num2 = calculadora.inputNum2.text.toString()
            var aux1 = 0.0
            var aux2 = 0.0

            if(num1.isNotEmpty()) {
                aux1 = num1.toDouble()
            }

            if(num2.isNotEmpty()) {
                aux2 = num2.toDouble()
            }

            var resultado = aux1-aux2
            calculadora.txtResFinal.text = ""+resultado
        }

        // Cuando pulsemos el boton de multiplicar comprobará si algun
        // valor está vacio, y si está vacio, se pone a 0 y se muestra el resultado
        var multiplicar = calculadora.btnMultiplicar

        multiplicar.setOnClickListener {
            var num1 = calculadora.inputNum1.text.toString()
            var num2 = calculadora.inputNum2.text.toString()
            var aux1 = 0.0
            var aux2 = 0.0

            if(num1.isNotEmpty()) {
                aux1 = num1.toDouble()
            }

            if(num2.isNotEmpty()) {
                aux2 = num2.toDouble()
            }

            var resulado = aux1*aux2
            calculadora.txtResFinal.text = ""+resulado
        }

        // Cuando pulsemos la opción de dividir si alguno de los
        // valores está vacio, se acambia a 0 y muetra el resultado
        var dividir = calculadora.btnDividir

        dividir.setOnClickListener {
            var num1 = calculadora.inputNum1.text.toString()
            var num2 = calculadora.inputNum2.text.toString()
            var aux1 = 0.0
            var aux2 = 0.0
            var resultado = 0.0;

            if(num1.isNotEmpty()) {
                aux1 = num1.toDouble()
            }

            if(num2.isNotEmpty()) {
                aux2 = num2.toDouble()
            }

            if (aux2==0.0) {
                resultado = 0.0
                Toast.makeText(applicationContext, "No es posible la division", Toast.LENGTH_SHORT).show()
            } else {
                resultado = aux1/aux2
            }

            calculadora.txtResFinal.text = ""+resultado
        }

        // Cuando pulsemos el boton de volver muestra la vista del login
        var volver = calculadora.btnRetroceso

        volver.setOnClickListener {
            setContentView(main.root)
        }
    }
}