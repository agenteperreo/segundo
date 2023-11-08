package com.example.piedrapapeltijeras

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview


class LogIn(
    navController:NavHostController,
    database: PlayerDatabase
) {

}

@Composable
fun Log() {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Row {
            OutlinedTextField(value = "", onValueChange = "")
        }
    }
}

@Preview
@Composable
fun LogInPreview() {
    LogIn(navController = NavHostController(localContext.current), database = PlayerDatabase.getInstance(
        LocalContext.current))
}