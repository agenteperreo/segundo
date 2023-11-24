package com.example.ppt_room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.lifecycle.ViewModelProvider

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ppt_room.Room.AppDatabase
import com.example.ppt_room.ui.theme.PPTRoomTheme

class MainActivity : ComponentActivity() {

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa tu base de datos
        database = AppDatabase.getInstance(applicationContext)

        setContent {
            PPTRoomTheme {
                val navController = rememberNavController()

                // Define la estructura de navegación
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(navController = navController, database = database)
                    }
                    composable("game/{username}") { backStackEntry ->
                        val username = backStackEntry.arguments?.getString("username") ?: ""
                        GameScreen(navController = navController, username = username, database = database)
                    }
                    composable("ranking") {
                        RankingScreen(navController= navController, database = database)
                    }
                }
            }
        }
    }
}