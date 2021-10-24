package com.example.k2p.presentation.meals

import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.model.Food
import com.example.k2p.domain.usecase.GetRandomFood
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
                state.value = FoodViewState.FoodReceived(it.food ?: Food())

                true
            }
        }
    }

}