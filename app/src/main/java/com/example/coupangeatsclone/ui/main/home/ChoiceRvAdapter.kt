package com.example.coupangeatsclone.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeatsclone.databinding.ItemHomeChoiceRvBinding

class ChoiceRvAdapter : RecyclerView.Adapter<ChoiceRvAdapter.ViewHolder>() {
    inner class ViewHolder(val binding : ItemHomeChoiceRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeChoiceRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 8
    }
}