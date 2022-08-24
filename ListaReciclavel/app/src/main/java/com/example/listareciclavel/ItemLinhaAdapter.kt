package com.example.listareciclavel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listareciclavel.databinding.ItemListaBinding
import com.example.listareciclavel.model.pais

class ItemLinhaAdapter : RecyclerView.Adapter<ItemLinhaAdapter.ItemLinhaHolder>() {

    val lista: MutableList<pais> = mutableListOf()

    class ItemLinhaHolder(val itemListaView: ItemListaBinding) : RecyclerView.ViewHolder(itemListaView.root) {

        fun bind(item: pais){
            itemListaView.pais.text = item.pais
            itemListaView.continente.text = item.continente
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemLinhaHolder {
        return ItemLinhaHolder(
            ItemListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemLinhaHolder, position: Int) {
        holder.bind(lista[position])
        holder.itemListaView.itemAddBtm.setOnClickListener {
            removeLista(lista[position])
        }
    }

    override fun getItemCount(): Int = lista.size

    fun setLista(listaItem: MutableList<pais>){
        lista.clear()
        lista.addAll(listaItem)
        notifyDataSetChanged()
    }

    fun addLista(newItem: pais) {
        lista.add(newItem)
        notifyItemInserted(lista.size)
    }

    fun removeLista(removed: pais) {
        val removedIndex = lista.indexOf(removed)
        lista.remove(removed)
        notifyItemRemoved(removedIndex)
        notifyItemRangeChanged(removedIndex, lista.size);
    }

}