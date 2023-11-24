package com.example.ppt_room

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ppt_room.Room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun GameScreen(navController: NavHostController, username: String, database: AppDatabase) {
    var machineChoice by remember { mutableStateOf("") }
    var playerChoice by remember { mutableStateOf("") }
    var playerScore by remember { mutableStateOf(0) }
    var machineScore by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text( "$username $playerScore - $machineScore Máquina", fontWeight = FontWeight.Bold)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MachineChoice(machineChoice)
            PlayerChoice(playerChoice, username)
        }

        PlayerChoices(
            machineScore = machineScore,
            onChoiceSelected = { choice ->
                // Simula una elección aleatoria de la máquina
                val choices = listOf("Piedra", "Papel", "Tijeras")
                val randomIndex = (0 until choices.size).random()
                machineChoice = choices[randomIndex]
                playerChoice = choice

                // Implementa la lógica del juego para determinar el resultado
                val result = determineGameResult(playerChoice, machineChoice)

                // Actualiza las puntuaciones
                when (result) {
                    "Ganaste" -> playerScore++
                    "Perdiste" -> machineScore++
                }
            },
            onGameEnd = {
                // Verifica el final del juego y navega al ranking solo si la máquina ha llegado a 3 victorias
                if (machineScore == 3) {
                    // Actualiza las estadísticas del usuario en la base de datos
                    GlobalScope.launch(Dispatchers.IO) {
                        val user = database.usuarioDao().getUserByUsername(username)
                            // Incrementa las partidas jugadas
                            user.partidasJugadas += 1
                            // Actualiza la máxima puntuación si es mayor que la existente
                            if (playerScore > user.maxPuntuacion) {
                                user.maxPuntuacion = playerScore


                            // Guarda los cambios en la base de datos
                            database.usuarioDao().updateUserStats(user)
                        }
                    }

                    // Navega al ranking
                    navController.navigate("ranking")
                }
            }
        )
    }
}



@Composable
fun MachineChoice(choice: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Máquina")
        Text(choice, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun PlayerChoice(choice: String, username: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(username)
        Text(choice, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun PlayerChoices(
    machineScore: Int,
    onChoiceSelected: (String) -> Unit,
    onGameEnd: () -> Unit // Agregamos el parámetro onGameEnd
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Jugador")
        Row {
            ChoiceButton("Piedra") {
                onChoiceSelected("Piedra")
                checkGameEnd(machineScore, onGameEnd)
            }
            ChoiceButton("Papel") {
                onChoiceSelected("Papel")
                checkGameEnd(machineScore, onGameEnd)
            }
            ChoiceButton("Tijeras") {
                onChoiceSelected("Tijeras")
                checkGameEnd(machineScore, onGameEnd)
            }
        }
    }
}

fun checkGameEnd(machineScore: Int, onGameEnd: () -> Unit) {
    // Lógica para verificar el final del juego
    // Verifica si la máquina ha llegado a 3 victorias
    if (machineScore == 3) {
        onGameEnd.invoke()
    }
}

@Composable
fun ChoiceButton(choice: String, onChoiceSelected: () -> Unit) {
    Button(onClick = onChoiceSelected, modifier = Modifier.padding(4.dp)) {
        Text(choice)
    }
}

fun determineGameResult(playerChoice: String, machineChoice: String): String {
    // Implementa tu lógica para determinar el resultado del juego
    // Puedes comparar las elecciones del jugador y la máquina y devolver "Ganaste", "Perdiste" o "Empate" según las reglas del juego.
    // Por ejemplo:
    return when {
        (playerChoice == "Piedra" && machineChoice == "Tijeras") ||
                (playerChoice == "Papel" && machineChoice == "Piedra") ||
                (playerChoice == "Tijeras" && machineChoice == "Papel") -> "Ganaste"

        playerChoice == machineChoice -> "Empate"

        else -> "Perdiste"
    }
}

@Preview
@Composable
fun GameScreenPreview() {
    GameScreen(navController = rememberNavController(), username = "username", database = AppDatabase.getInstance(LocalContext.current))
}