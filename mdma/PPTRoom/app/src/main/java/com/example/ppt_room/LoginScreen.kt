package com.example.ppt_room

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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ppt_room.Room.AppDatabase
import com.example.ppt_room.Room.UsuarioEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    database: AppDatabase
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Iniciar sesión",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (username.isNotBlank() && password.isNotBlank()) {
                    // Utilizamos un CoroutineScope para lanzar la operación en el hilo principal
                    CoroutineScope(Dispatchers.Main).launch {
                        // Comprueba si el usuario existe en la base de datos
                        val existingUser = database.usuarioDao().getUser(username, password)

                        if (existingUser != null) {
                            // Verifica la contraseña
                            if (existingUser.password == password) {
                                // Si el usuario existe y la contraseña es correcta, navega a la pantalla del juego
                                navController.navigate("game/$username")
                            } else {
                                // Si la contraseña es incorrecta, muestra un mensaje o maneja de otra manera
                                println("Contraseña incorrecta")
                            }
                        } else {
                            // Si el usuario no existe, muestra un mensaje o maneja de otra manera
                            //generamos un usuario con el nick y la contraseña
                            val usuario = UsuarioEntity(
                                nick = username,
                                password = password,
                                partidasJugadas = 0,
                                maxPuntuacion = 0
                            )
                            //insertamos el usuario en la base de datos
                            database.usuarioDao().insertUserStats(usuario)
                            //navegamos a la pantalla del juego
                            navController.navigate("game/$username")
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar sesión")
        }
    }
}
