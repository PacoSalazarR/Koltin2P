package com.example.k2p.presentation.random

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.k2p.R
import com.example.k2p.core.extension.failure
import com.example.k2p.core.extension.observe
import com.example.k2p.core.presentation.BaseFragment
import com.example.k2p.core.presentation.BaseViewState
import com.example.k2p.databinding.RandomMealFragmentBinding
import com.example.k2p.domain.model.Food
import com.example.k2p.presentation.foods.FoodViewState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class RandomMealFragment : BaseFragment(R.layout.random_meal_fragment) {

    private lateinit var binding: RandomMealFragmentBinding
    private val adapter: RandomMealAdapter by lazy { RandomMealAdapter() }

    private val foodViewModel by viewModels<RandomMealViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)

            doGetRandomFood()
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when(state) {
            is FoodViewState.FoodsReceived -> setUpAdapter(state.meals)
        }
    }

    private fun setUpAdapter(foods: List<Food>){
        adapter.addData(foods)

        binding.recyclerRandom.apply {
            adapter = this@RandomMealFragment.adapter
        }
    }

    override fun setBinding(view: View) {

        binding = RandomMealFragmentBinding.bind(view)

        binding.lifecycleOwner = this

    }

}