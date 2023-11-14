package com.example.roomcontactos

import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.roomcontactos.databinding.ItemContactoBinding

class ContactosAdapter(private val contactos: List<Contacto>, private val contactoPulsadorListener: ContactosPulsadorListener) :
    RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemContactoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contacto: Contacto) {
            binding.txtNombre.text = contacto.name
            binding.txtTelefono.text = contacto.telf

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

        var initNombre = contactos[position].name.split(" ").mapNotNull { it.firstOrNull() }.joinToString("")

        holder.binding.txtIniciales.text = initNombre


        // ponemos visible o invisible segun clicas o no
        holder.binding.imgAvatar.setOnClickListener {
            if (holder.binding.txtIniciales.isVisible) {
                holder.binding.txtIniciales.visibility = View.GONE

                holder.binding.txtNombre.visibility = View.VISIBLE
                holder.binding.txtTelefono.visibility = View.VISIBLE

            } else {
                holder.binding.txtIniciales.visibility = View.VISIBLE
                holder.binding.txtNombre.visibility = View.GONE
                holder.binding.txtTelefono.visibility = View.GONE
            }

            holder.binding.contenedor.setOnClickListener {
                contactoPulsadorListener.contactoPulsado(contactos[position])
            }

            TransitionManager.beginDelayedTransition(holder . binding . contenedor)
        }
    }
}