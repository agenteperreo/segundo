package com.example.piedrapapeltijeras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.piedrapapeltijeras.room.PlayerDatabase
import com.example.piedrapapeltijeras.ui.theme.PiedraPapelTijerasTheme

class MainActivity : ComponentActivity() {

    private lateinit var database: PlayerDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = PlayerDatabase.getInstance(applicationContext)

        setContent {
            PiedraPapelTijerasTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(navController = navController, database = database)
                    }

                    composable("game/{username}") { backStackEntry ->
                        val username =backStackEntry.arguments?.getString("username") ?: ""
                        GameScreen(navController = navController, username = username, database = database)
                    }

                    composable("leaderboard") {
                        TableScreen(navController = navController, database = database)
                    }
                }
            }
        }
    }
}

