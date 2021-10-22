package com.example.k2p.presentation.meals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.k2p.R
import com.example.k2p.core.extension.failure
import com.example.k2p.core.extension.observe
import com.example.k2p.core.presentation.BaseFragment
import com.example.k2p.core.presentation.BaseViewState
import com.example.k2p.databinding.MealFragmentBinding
import com.example.k2p.domain.model.Category

class MealFragment : BaseFragment(R.layout.meal_fragment) {
    private lateinit var binding: MealFragmentBinding

    private lateinit var adapter: MealAdapter
    private val mealViewModel by viewModels<MealViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mealViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure,::handleFailure)
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when(state){

        }
    }

    private fun setUpAdapter(meals: List<Category>){
        adapter = MealAdapter()

        adapter.addData(meals)//addList

        binding.recyclerMeals.apply {
            adapter = this@MealFragment.adapter
        }
    }

    override fun setBinding(view: View) {
        binding = MealFragmentBinding.bind(view)

        binding.lifecycleOwner = this
    }


}