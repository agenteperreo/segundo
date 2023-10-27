package com.example.piedrapapeltijeras

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Identity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.piedrapapeltijeras.ui.theme.PiedraPapelTijerasTheme

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
                    Row(
                        verticalAlignment = Alignment.Top
                    ) {
                        Mandos()
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Elecciones()
                    }

                    Row(
                        verticalAlignment = Alignment.Bottom
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
        )

        Image(
            painter = painterResource(id = R.drawable.papel),
            contentDescription = "Papel",
            modifier = Modifier
                .weight(1F)
                .size(100.dp, 100.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.tijeras),
            contentDescription = "Tijeras",
            modifier
                .weight(1F)
                .size(100.dp, 100.dp)
        )

    }
}


@Composable
fun Elecciones(modifier: Modifier = Modifier) {

    Column {
        Text(
            text = "Jugador"
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Eleccion jugador",
            modifier = Modifier.size(100.dp, 100.dp)
        )

    }

    Column {
        Text(
            text = "Maquina"
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Eleccion jugador",
            modifier = Modifier.size(100.dp, 100.dp)
        )
    }

}