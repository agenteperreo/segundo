package com.example.ejemplorv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorv.databinding.ItemContactoBinding

class ContactosAdapter(private val contactos: List<Contacto>, private val contactoPulsadorListener: ContactoPulsadorListener) :
    RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemContactoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contacto: Contacto) {
            binding.txtNombre.text = contacto.nombre
            binding.txtTelefono.text = contacto.tlfno

            if(contacto.genero.equals("H")) {
                binding.imgAvatar.setImageResource(R.drawable.jefe)
            } else {
                binding.imgAvatar.setImageResource(R.drawable.mujer)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = contactos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactos[position])

        var initNombre = contactos[position].nombre.split(" ").mapNotNull { it.firstOrNull() }.joinToString("")

        holder.binding.txtIniciales.text = initNombre

        holder.itemView.setOnClickListener {
            contactoPulsadorListener.contactoPulsado(contactos[position])
        }
    }
}