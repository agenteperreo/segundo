package com.example.galeriaimagenes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galeriaimagenes.databinding.ItemImagenesBinding


class ImagenesAdapter(private val imagenes : List<Imagen>) :
    RecyclerView.Adapter<ImagenesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemImagenesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imagen: Imagen){
            Glide
                .with(binding.root)
                .load(imagen.url)
                .into(binding.imgAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemImagenesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = imagenes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imagenes[position])
    }

}