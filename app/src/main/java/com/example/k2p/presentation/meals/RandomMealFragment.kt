package com.example.k2p.presentation.meals

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.k2p.R

class RandomMealFragment : Fragment() {

    companion object {
        fun newInstance() = RandomMealFragment()
    }

    private lateinit var viewModel: RandomMealViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.random_meal_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RandomMealViewModel::class.java)
        // TODO: Use the ViewModel
    }

}