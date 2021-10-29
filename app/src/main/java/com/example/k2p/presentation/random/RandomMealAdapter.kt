package com.example.k2p.presentation.random

import android.annotation.SuppressLint
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.k2p.R
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

        var flag: Boolean = false
                fun bind(data: Food){
                    binding.food = data

                    binding.txtInstructions.movementMethod = ScrollingMovementMethod()

                    binding.btnFav.setOnClickListener {
                        flag = if(!flag){
                            binding.btnFav.setImageResource(R.drawable.ic_full_star)
                            true
                        }else{
                            binding.btnFav.setImageResource(R.drawable.ic_empty_star)
                            false
                        }
                    }
                }
        }
}