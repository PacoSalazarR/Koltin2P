package com.example.k2p.presentation.mealdetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.k2p.R
import com.example.k2p.core.extension.failure
import com.example.k2p.core.extension.observe
import com.example.k2p.core.presentation.BaseFragment
import com.example.k2p.core.presentation.BaseViewState
import com.example.k2p.databinding.DetailFoodFragmentBinding
import com.example.k2p.domain.model.Food
import com.example.k2p.presentation.meals.FoodViewState
import com.example.k2p.presentation.meals.RandomMealAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class DetailFoodFragment : BaseFragment(R.layout.detail_food_fragment) {

    private lateinit var binding: DetailFoodFragmentBinding
    private val adapter: RandomMealAdapter by lazy { RandomMealAdapter() }

    private val args: DetailFoodFragmentArgs by navArgs()

    private val foodViewModel by viewModels<DetailFoodViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)

            doGetFoodById(args.food.idMeal.toString())
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
        binding.recyclerDetail.apply {
            adapter = this@DetailFoodFragment.adapter
        }
    }

    override fun setBinding(view: View) {
        binding = DetailFoodFragmentBinding.bind(view)
        binding.lifecycleOwner = this
    }


}