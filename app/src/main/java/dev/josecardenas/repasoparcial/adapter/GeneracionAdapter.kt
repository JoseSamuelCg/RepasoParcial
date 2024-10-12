package dev.josecardenas.repasoparcial.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.josecardenas.repasoparcial.R
import dev.josecardenas.repasoparcial.model.GeneracionModel

class GeneracionAdapter(private var generacionList: List<GeneracionModel>):
    RecyclerView.Adapter<GeneracionAdapter.ViewHolder>() {

    // ViewHolder para cada ítem en la lista
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvGeneracion: TextView = itemView.findViewById(R.id.tvGeneracion)
        val tvAnio: TextView = itemView.findViewById(R.id.tvAnio)
        val ivGeneracion: ImageView = itemView.findViewById(R.id.ivGeneracion)
    }

    // Inflar el layout para cada ítem del RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_generacion, parent, false)
        return ViewHolder(view)
    }

    // Vincular los datos del modelo con las vistas del ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = generacionList[position]
        holder.tvGeneracion.text = item.generacion
        holder.tvAnio.text = item.anio.toString()
        holder.ivGeneracion.setImageResource(item.imagen)
    }

    // Devolver el tamaño de la lista
    override fun getItemCount(): Int {
        return generacionList.size
    }

    // Método opcional para actualizar la lista de datos
    fun updateGeneracionList(newGeneracionList: List<GeneracionModel>) {
        generacionList = newGeneracionList
        notifyDataSetChanged()
    }
}
