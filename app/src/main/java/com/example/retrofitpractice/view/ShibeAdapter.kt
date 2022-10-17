package com.example.retrofitpractice.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.retrofitpractice.databinding.ShibeCardBinding

class ShibeAdapter : RecyclerView.Adapter<CardHolder>() {
    val shibeList: MutableList<String> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        return CardHolder(
            ShibeCardBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.display(shibeList[position])
    }

    override fun getItemCount() = shibeList.size
    fun updateScreen(newList: List<String>) {
        val oldList = shibeList.size
        shibeList.clear()
        notifyItemRangeChanged(0, oldList)
        shibeList.addAll(newList)
        notifyItemRangeChanged(0, newList.size)
    }
}

class CardHolder(private val binding: ShibeCardBinding) : RecyclerView.ViewHolder(binding.root) {
    fun display(card: String) {
        binding.shibeImage.load(
            data = card
        ) {
            this.scale(Scale.FIT)
        }
    }
}