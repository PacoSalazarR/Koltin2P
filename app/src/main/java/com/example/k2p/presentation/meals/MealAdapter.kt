package com.example.k2p.presentation.meals

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.k2p.databinding.RowMealBinding
import com.example.k2p.domain.model.Category


class MealAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<Category> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(list: List<Category>){
        this.list = list.toMutableList()

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderItem(
        RowMealBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as ViewHolderItem).bind(
        list[position]
    )

    override fun getItemCount() = list.size

    class ViewHolderItem(private val binding: RowMealBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Category) {
            binding.item = data
        }
    }
}