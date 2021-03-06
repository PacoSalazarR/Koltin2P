package com.example.k2p.presentation.foods

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.k2p.databinding.GridFoodBinding
import com.example.k2p.domain.model.Food

@SuppressLint("NotifyDataSetChanged")
class FoodAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<Food> = mutableListOf()
    lateinit var listener: (food: Food) -> Unit

    fun addData(list: List<Food>){
        this.list = list.toMutableList()

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderGridItem(
        GridFoodBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as ViewHolderGridItem).bind(
        list[position], listener
    )

    override fun getItemCount() = list.size

    class ViewHolderGridItem(private val  binding: GridFoodBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(data: Food, listener: (food: Food)->Unit) {
            binding.item = data

            //binding.imgFood.load(data.urlMealThumb)

            binding.root.setOnClickListener {
                listener(data)
            }
        }
    }
}