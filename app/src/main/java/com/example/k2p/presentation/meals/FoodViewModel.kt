package com.example.k2p.presentation.meals

import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.usecase.GetFoodsByCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class FoodViewModel @Inject constructor(private val getFoodsByCategory: GetFoodsByCategory) :
    BaseViewModel() {

    fun doGetFoodsByCategory(category: String){
        getFoodsByCategory(category){
            it.fold(::handleFailure){
                state.value = FoodViewState.FoodsReceived(it.foods ?: listOf())

                true
            }
        }
    }

}