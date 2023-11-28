package com.example.examen1moviles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.examen1moviles.room.AppDatabase
import com.example.examen1moviles.room.ConfiguraciónEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Creamos una funcion composable que se llamará en el MainActivity
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfiguracionScreen(
    // controlador de navegación para pasar a otra pagina
    navController: NavHostController,

    // Base de datos para guardar información
    database: AppDatabase
) {
    // Variables utiles para la actualización de los campos de la base de datos con el remember para que no cambien
    var numSalas by remember { mutableStateOf(0) }
    var numAsientos by remember { mutableStateOf(0) }

    // Columna principal que contendrá toda interfaz de la pagina
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Texto de lo que piden en los siguientes entrys
        Text(
            text = "Establece la configuración basica del cine",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Entry para la cantidad de salas del cine
        OutlinedTextField(
            value = numSalas.toString(),
            onValueChange = { numSalas = it.toIntOrNull() ?: 0 },
            label = { Text(text = "Numero de salas") },
            modifier = Modifier.fillMaxWidth()
        )

        // Espaciador pa que quede bonito
        Spacer(modifier = Modifier.height(16.dp))

        // Entry para la cantidad de butacas por sala
        OutlinedTextField(
            value = numAsientos.toString(),
            onValueChange = { numAsientos = it.toIntOrNull() ?: 0 },
            label = { Text(text = "Numero de asientos por sala") },
            modifier = Modifier.fillMaxWidth()
        )

        // Espaciador para que quede bonito
        Spacer(modifier = Modifier.height(16.dp))

        // Boton para guardar los entrys y navegar a la siguiente pagina
        Button(
            // cuando clickemos el boton
            onClick = {
                // corutina para ejecutar un update de la base de datos
                CoroutineScope(Dispatchers.Main).launch {

                    // Creamos un objeto de tipo ConfiguracionEntity con los parametros
                    val configuracion = ConfiguraciónEntity(
                        numSalas = numSalas,
                        numAsientos = numAsientos,
                        precioPalomitas = (2..4).random().toFloat()
                    )

                    // Llamamos a la funcion updateConfiguration de la base de datos con el objeto anterior por parametros
                    database.appDao().updateConfiguration(configuracion)

                    navController.navigate("salas")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Guardar")
        }
    }
}
