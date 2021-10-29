package com.example.k2p.presentation.random

import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.usecase.GetRandomFood
import com.example.k2p.presentation.foods.FoodViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class RandomMealViewModel @Inject constructor(private val getRandomFood: GetRandomFood) :
    BaseViewModel() {

    fun doGetRandomFood(){
        getRandomFood(""){
            it.fold(::handleFailure){
                state.value = FoodViewState.FoodsReceived(it.meals ?: listOf())

                true
            }
        }
    }

}