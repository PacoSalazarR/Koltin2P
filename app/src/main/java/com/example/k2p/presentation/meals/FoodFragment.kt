package com.example.k2p.presentation.meals

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
import com.example.k2p.databinding.FoodFragmentBinding
import com.example.k2p.domain.model.Food
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class FoodFragment : BaseFragment(R.layout.food_fragment) {

    private lateinit var binding: FoodFragmentBinding
    private val adapter: FoodAdapter by lazy { FoodAdapter() }

    private val args: FoodFragmentArgs by navArgs()

    private val foodViewModel by viewModels<FoodViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)

            doGetFoodsByCategory(args.category.category)
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when(state) {
            is FoodViewState.FoodsReceived -> setUpAdapter(state.foods)
        }
    }

    private fun setUpAdapter(foods: List<Food>){
        //adapter = FoodAdapter()

        adapter.addData(foods)

        binding.recyclerFoods.apply {
            adapter = this@FoodFragment.adapter
        }
    }

    override fun setBinding(view: View) {
        binding = FoodFragmentBinding.bind(view)

        binding.lifecycleOwner = this
    }

}