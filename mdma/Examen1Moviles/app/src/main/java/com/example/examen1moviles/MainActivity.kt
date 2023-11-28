package com.example.examen1moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examen1moviles.room.AppDatabase
import com.example.examen1moviles.ui.theme.Examen1MovilesTheme

class MainActivity : ComponentActivity() {

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // instanciamos ala base de datos que vamos a usar
        database = AppDatabase.getInstance(applicationContext)

        /* TODO: Implementar el topbar para la barra de elccion de arriba*/
        setContent {
            Examen1MovilesTheme {

                // Controlador de navegación
                val navController = rememberNavController()

                // Navegaciones entre paginas
                NavHost(navController = navController, startDestination = "config") {

                    // Pagina de la configuracion basica del cine
                    composable("config") {
                        ConfiguracionScreen(navController, database)
                    }

                    // Pagina de salas y simulación de cliente
                    composable("salas") {
                        SalasScreen(database, navController)
                    }

                    // Pagina de resumen de asistencia
                    composable("resumen") {
                        ResumenAsistencia(database, navController)
                    }

                    // Pagina de detalles de la sala
                    composable("detalles") {
                        DetallesScreen(database)
                    }
                }

            }
        }
    }
}

