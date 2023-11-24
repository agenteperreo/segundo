package com.example.ppt_room

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ppt_room.Room.AppDatabase
import com.example.ppt_room.Room.UsuarioEntity

@Composable
fun RankingScreen(
    navController: NavController,
    database: AppDatabase
) {
    var userStatsList by remember { mutableStateOf(listOf<UsuarioEntity>()) }

    // Obtener la lista de puntuaciones de la base de datos
    LaunchedEffect(key1 = true) {
        val usuarioDao = database.usuarioDao()
        userStatsList = usuarioDao.getAllUserStats()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Ranking de Jugadores",
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {
            items(userStatsList) { userStats ->
                PlayerRankingItem(userStats = userStats)
            }
        }
    }
}

@Composable
fun PlayerRankingItem(userStats: UsuarioEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = userStats.nick,
            fontWeight = FontWeight.Bold
        )

        Text(text = "Partidas Jugadas: ${userStats.partidasJugadas}")
        Text(text = "Máxima Puntuación: ${userStats.maxPuntuacion}")
    }
}

@Preview
@Composable
fun PlayerRankingItemPreview() {
    RankingScreen(navController = NavHostController(LocalContext.current), database = AppDatabase.getInstance(LocalContext.current))
}
