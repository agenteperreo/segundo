package com.example.piedrapapeltijeras

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.piedrapapeltijeras.ui.theme.PiedraPapelTijerasTheme
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PiedraPapelTijerasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Mandos()
                    }
                }
            }
        }
    }
}


@Composable
fun Mandos(modifier: Modifier = Modifier) {

    // Imagen clickada por el jugador
    var jugador = remember {
        mutableStateOf(0)
    }

    // Imagen pulsada por la maquina
    var maquina = remember {
        mutableStateOf(0)
    }

    // Imagen a la que se cambiará la imagen central del jugador
    var imagen: Int

    // Dependiendo de la imagen pulsada tiene un valor u otro
    if (jugador.value == 1)
        imagen = R.drawable.piedra
    else if (jugador.value == 2)
        imagen = R.drawable.papel
    else if (jugador.value == 3)
        imagen = R.drawable.tijeras
    else
        imagen = R.drawable.ic_launcher_background

    var imagenM: Int

    if (maquina.value == 1)
        imagenM = R.drawable.piedra
    else if (maquina.value == 2)
        imagenM = R.drawable.papel
    else if (maquina.value == 3)
        imagenM = R.drawable.tijeras
    else
        imagenM = R.drawable.ic_launcher_background

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.piedra),
                contentDescription = "Piedra",
                modifier = Modifier
                    .weight(1F)
                    .size(100.dp, 100.dp)
                    .clickable {
                        maquina.value = 1
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.papel),
                contentDescription = "Papel",
                modifier = Modifier
                    .weight(1F)
                    .size(100.dp, 100.dp)
                    .clickable {
                        maquina.value = 2
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.tijeras),
                contentDescription = "Tijeras",
                modifier
                    .weight(1F)
                    .size(100.dp, 100.dp)
                    .clickable {
                        maquina.value = 3
                    }
            )

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column {
                Text(
                    text = "Jugador"
                )

                Image(
                    painter = painterResource(id = imagen),
                    contentDescription = "Eleccion jugador",
                    modifier = Modifier.size(100.dp, 100.dp)
                )

            }

            Column {
                Text(
                    text = "Maquina"
                )

                Image(
                    painter = painterResource(id = imagenM),
                    contentDescription = "Eleccion Maquina",
                    modifier = Modifier.size(100.dp, 100.dp)
                )
            }
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.piedra),
                contentDescription = "Piedra",
                modifier = Modifier
                    .weight(1F)
                    .size(100.dp, 100.dp)
                    .clickable {
                        jugador.value = 1
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.papel),
                contentDescription = "Papel",
                modifier = Modifier
                    .weight(1F)
                    .size(100.dp, 100.dp)
                    .clickable {
                        jugador.value = 2
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.tijeras),
                contentDescription = "Tijeras",
                modifier
                    .weight(1F)
                    .size(100.dp, 100.dp)
                    .clickable {
                        jugador.value = 3
                    }
            )

        }
    }

}
