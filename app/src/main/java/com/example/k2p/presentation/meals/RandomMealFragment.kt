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
import com.example.k2p.databinding.RandomMealFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class RandomMealFragment : BaseFragment(R.layout.random_meal_fragment) {

    private lateinit var binding: RandomMealFragmentBinding

    private val foodViewModel by viewModels<RandomMealViewModel>()

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }*/


    override fun setBinding(view: View) {
        binding = RandomMealFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@RandomMealFragment
        }
    }


}