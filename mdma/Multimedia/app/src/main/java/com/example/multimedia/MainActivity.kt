package com.example.multimedia

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.multimedia.ui.theme.MultimediaTheme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultimediaTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    PlayVideo()
                }

            }
        }
    }
}

@Composable
fun PlayVideo() {
    val context = LocalContext.current
    // Opción 1: Archivo en disco (Nota: android.permission.WRITE_EXTERNAL_STORAGE)
    val clip = File(Environment.getExternalStorageDirectory(), "libro.mp4")
    videoView1.setVideoPath(clip.path);
    reproducir(videoView1)
// Opción 2: Archivo en directorio res/raw (Nota: no debemos escribir la extensión)
    val videoView2 = findViewById(R.id.videoView2)
    videoView2.setVideoURI(Uri.parse("android.resource://$packageName/raw/libro"))
    reproducir(videoView2)
// Opción 3: Archivo en Internet (Nota: android.permission.INTERNET)
    val videoView3 = findViewById(R.id.videoView3)
    videoView3.setVideoPath("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4")
    reproducir(videoView3)
}

@Composable
fun videoView(videoPlayerController : VideoPlayerController) {

}

class VideoPlayerController(context:Context) {
    var videoUri: Uri? = null
        private set

    var setVideoPath(path)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultimediaTheme {
        PlayVideo()
    }
}