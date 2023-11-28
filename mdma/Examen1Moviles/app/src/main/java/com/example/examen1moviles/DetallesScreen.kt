package com.example.examen1moviles

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.examen1moviles.room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun DetallesScreen(
    database: AppDatabase
) {
    // variables utiles para la clase
    var numeroSala by remember { mutableStateOf(0) }
    var numeroAsientos by remember { mutableStateOf(0) }
    var numeroAsientoOcupados by remember { mutableStateOf(0) }
    var numeroPalomitas by remember { mutableStateOf(0) }
    var dineroPalomitas by remember { mutableStateOf(0) }

    /*TODO: recopilar los datos para la muestra de la información*/
    /*CoroutineScope(Dispatchers.Main) {
        numeroSala = database.appDao().getSala()
        numeroAsientos = database.appDao().getAsientos()
    }*/

    /*TODO: Mostrar todos los datos*/
    Text(text = "Numero de sala: ")
}