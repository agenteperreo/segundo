package com.example.apliacininiciodesesion

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.apliacininiciodesesion.databinding.ActivityMainBinding
import com.example.apliacininiciodesesion.databinding.BienvenidaBinding
import com.example.apliacininiciodesesion.databinding.PausaBinding

class MainActivity : AppCompatActivity() {

    var nombre = ""

    var contasena = ""

    var pausa = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val activityMain = ActivityMainBinding.inflate(layoutInflater)

        val bienvenida = BienvenidaBinding.inflate(layoutInflater)

        setContentView(activityMain.root)

        var boton = activityMain.btnLogin

        nombre = activityMain.txtUsuarioInput.text.toString()

        boton.setOnClickListener {
            contasena = activityMain.txtContraseAInput.text.toString()
            if(contasena.equals("abc123")) {
                setContentView(bienvenida.root)
                bienvenida.txtBienvenida.text = "Nos alegramos de que vuelvas, $nombre"
            } else {
                Toast.makeText(applicationContext, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        }


    }
    override fun onPause() {
        super.onPause()

        Toast.makeText(applicationContext, "He parado", Toast.LENGTH_SHORT).show()

        val pausa = PausaBinding.inflate(layoutInflater)

        if(contasena.equals("abc123")){
            setContentView(pausa.root)
        }

    }
    override fun onResume() {
        super.onResume()

        Toast.makeText(applicationContext, "Bienvenido de nuevo $nombre", Toast.LENGTH_SHORT).show()

        val bienve = BienvenidaBinding.inflate(layoutInflater)

        if (contasena.equals("abc123")) {
            setContentView(bienve.root)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "mi_canal_id"
            val channelName = "Mi Canal de Notificación"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance)

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

        // Crea un intent para abrir una actividad cuando se toque la notificación
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

// Crea la notificación
        val notificationBuilder = NotificationCompat.Builder(this, "mi_canal_id")
            .setSmallIcon(R.drawable.ic_notificacion)
            .setContentTitle("Cierre de sesión")
            .setContentText("Se ha cerrado la sesión de $nombre")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true) // Cierra la notificación al tocarla
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

// Muestra la notificación
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(1, notificationBuilder.build())

    }

}