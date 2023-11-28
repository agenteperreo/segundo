package com.example.examen1moviles

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.examen1moviles.room.AppDatabase
import com.example.examen1moviles.room.ClientesEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SalasScreen(
    database: AppDatabase,
    navController: NavHostController
) {
    // clicks en el boton
    var clickCount:Long by remember { mutableStateOf(0) }

    // Cantidad de salas en el cine
    var numSalas by remember { mutableStateOf(0) }

    // Columna basse
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // texto
        Text(
            text = "Pulsa para el siguiente cliente",
            modifier = Modifier.padding(16.dp))

        // Boton para insetar el cliente en la base de datos
        Button(onClick = {

            CoroutineScope(Dispatchers.Main).launch {
                // Añadir un click al contador
                clickCount++

                // Cantidad de salas del cine
                numSalas = database.appDao().getSalas()

                // si compra palomitas o no
                var palomitas = (0..10).random().toInt()

                // Si las palomitas es mañor o igual que 5 come palomitas y si no no
                if(palomitas >= 5) {
                    palomitas = 1
                } else {
                    palomitas=0
                }

                // Creamos un cliente
                val cliente = ClientesEntity(
                    Id = clickCount,
                    salaElegida = (1..numSalas).random(),
                    palomitas = palomitas
                )

                // Añadimos el cliente a la tabla
                database.appDao().insertCliente(cliente)
            }
        },
            modifier = Modifier.fillMaxWidth()
        ) {
            // Texto del boton
            Text(text = "Nuevo cliente")
        }
    }

    // Espaciador para que quede bonito
    Spacer(modifier = Modifier.height(16.dp))

    // metodo que mostrará un lazy column con la cantidad de salas a elegir, al clicar navegará a detalles
    listaSalas(salas = numSalas)
}

/* TODO: Crear e implementar una lista de ImageButtons para el
    seteo de salas y el color de estas segun su cantidad de personas y navegar
    a la pantalla de detalles*/
@Composable
fun listaSalas(salas:Int) {

    /*val imageIds = (1..salas).toList()

    LazyColumn {
        items(imageIds) { imageId ->
            ImageButton(
                onClick = {

                }
            )
        }
    }*/
}

