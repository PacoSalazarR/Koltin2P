package com.example.k2p.presentation.meals

import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.usecase.GetFoodsByCategory
import com.example.k2p.domain.usecase.GetFoodsByName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class FoodViewModel @Inject constructor(private val getFoodsByCategory: GetFoodsByCategory, private val getFoodsByName: GetFoodsByName) :
    BaseViewModel() {

    fun doGetFoodsByCategory(category: String){
        getFoodsByCategory(category){
            it.fold(::handleFailure){
                state.value = FoodViewState.FoodsReceived(it.meals ?: listOf())

                true
            }
        }
    }

    fun doGetFoodsByName(name: String){
        getFoodsByName(name){
            it.fold(::handleFailure){
                state.value = FoodViewState.FoodsReceived(it.meals ?: listOf())
                true
            }
        }
    }

}