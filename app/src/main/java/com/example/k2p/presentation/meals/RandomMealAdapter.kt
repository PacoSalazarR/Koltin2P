package com.example.k2p.presentation.meals

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.k2p.databinding.RandomLayoutBinding
import com.example.k2p.domain.model.Food

@SuppressLint("NotifyDataSetChanged")
class RandomMealAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var list: MutableList<Food> = mutableListOf()

    fun addData(list: List<Food>) {
        this.list = list.toMutableList()

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderRandomItem(
        RandomLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as ViewHolderRandomItem).bind(
        list[position]
    )

    override fun getItemCount() = list.size

    class ViewHolderRandomItem(private val binding: RandomLayoutBinding) :
        RecyclerView.ViewHolder(binding.root){
                fun bind(data: Food){
                    binding.food = data

                    binding.imgMeal.load(data.urlMealThumb)
                }
        }
}