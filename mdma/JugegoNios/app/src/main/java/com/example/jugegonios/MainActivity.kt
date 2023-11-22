package com.example.jugegonios

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jugegonios.ui.theme.JugegoNiñosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JugegoNiñosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    val mContext = LocalContext.current
    Column (
        modifier = Modifier.verticalScroll(rememberScrollState())
    ){

        Image(
            painter = painterResource(id = R.drawable.elefante),
            contentDescription = "Elefante",
            modifier = Modifier.size(400.dp, 400.dp)
                .clickable {
                    var mediaPlayer = MediaPlayer.create(mContext, R.raw.elefante)
                    mediaPlayer.start()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.leon),
            contentDescription = "Leon",
            modifier = Modifier.size(400.dp, 400.dp)
                .clickable {
                    var mediaPlayer = MediaPlayer.create(mContext, R.raw.leon)
                    mediaPlayer.start()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.serpiente),
            contentDescription = "Leon",
            modifier = Modifier.size(400.dp, 400.dp)
                .clickable {
                    var mediaPlayer = MediaPlayer.create(mContext, R.raw.serpiente)
                    mediaPlayer.start()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.vaca),
            contentDescription = "Leon",
            modifier = Modifier.size(400.dp, 400.dp)
                .clickable {
                    var mediaPlayer = MediaPlayer.create(mContext, R.raw.mugidovaca)
                    mediaPlayer.start()
                }
        )
    }
}