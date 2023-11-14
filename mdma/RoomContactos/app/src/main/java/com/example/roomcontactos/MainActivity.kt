package com.example.roomcontactos

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomcontactos.databinding.ContactosBinding
import com.example.roomcontactos.databinding.NuevoContactoBinding
import com.google.android.material.internal.ViewUtils.hideKeyboard
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Creamos un binding
        val contactos = ContactosBinding.inflate(layoutInflater)
        val nuevo = NuevoContactoBinding.inflate(layoutInflater)

        //Mostramos la vista de contactos
        setContentView(contactos.root)

        // Si clickamos en el boton de nuevo contacto
        contactos.btnNuevoContacto.setOnClickListener {

            // cambiamos de vista a la de buevo_contacto
            setContentView(nuevo.root)
        }

        // Si clickamos en el boton de añadir
        nuevo.btnCrear.setOnClickListener {
            var nuevoContacto = Contacto()
            setContentView(contactos.root)
        }

        //Generamos una lista de contactos
        contactos.vistaContactos.adapter = ContactosAdapter(
            listOf(
                Contacto(1,"Juan Antonio Fernandez Guerrero", "123456", "H"),
                Contacto(2,"María Palacios Sanchez", "678456123", "M"),
                Contacto(3,"Raúl Gamero Valiente", "644789456", "H"),
                Contacto(4,"Raúl", "644789456", "H"),
                Contacto(5,"Raúl", "644789456", "M"),
                Contacto(6,"Raúl", "644789456", "M"),
                Contacto(7,"Raúl", "644789456", "M"),
                Contacto(8,"Raúl", "644789456", "M"),
                Contacto(9,"Raúl", "644789456", "H"),
                Contacto(10,"Raúl", "644789456", "H"),
                Contacto(11,"Raúl", "644789456", "M"),
                Contacto(12,"Raúl", "644789456", "H"),
                Contacto(13,"Raúl", "644789456", "H"),
                Contacto(14,"Raúl", "644789456", "M")
            )
            ,
            // Sobreescribimos la funcion de la interfaz
            object : ContactosPulsadorListener {
                override fun contactoPulsado(contacto: Contacto) {
                    val dial = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contacto.telf))
                    startActivity(dial)
                }
            }
        )
    }

    fun addContacto(contacto:Contacto)= runBlocking{  // Corrutina que añade una tarea a la lista
        launch {
            val id = ContactosApp.database.ContactsDao().addContact(contacto)   // Inserta una tarea nueva
            val recoveryTask = ContactosApp.database.ContactsDao().getContactById(id)   // Recarga la lista
            contacto.add(recoveryTask) // Añade al final de la lista, el nuevo
            adapter.notifyItemInserted(contacto.size)  // El adaptador notifica que se ha insertado
            clearFocus()        // Se elimina el texto del et ...
            hideKeyboard()      // y se oculta el teclado
        }
    }
}