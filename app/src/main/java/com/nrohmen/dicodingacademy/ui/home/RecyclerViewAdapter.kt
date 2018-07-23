package com.nrohmen.dicodingacademy.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nrohmen.dicodingacademy.R
import com.nrohmen.dicodingacademy.R.id.academy_image
import com.nrohmen.dicodingacademy.R.id.academy_name
import com.nrohmen.dicodingacademy.data.model.Academy
import com.squareup.picasso.Picasso
import org.jetbrains.anko.sdk25.coroutines.onClick

class RecyclerViewAdapter(private val context: Context, private val items: List<Academy>, private val listener: (Academy) -> Unit)
    : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_event, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val name: TextView = view.findViewById(academy_name)
    private val image: ImageView = view.findViewById(academy_image)

    fun bindItem(items: Academy, listener: (Academy) -> Unit) {
        name.text = items.name
        items.image?.let { Picasso.get().load(it).into(image) }
        itemView.onClick { listener(items) }
    }
}