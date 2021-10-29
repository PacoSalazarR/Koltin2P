package com.example.k2p.presentation.foods

import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.model.Food
import com.example.k2p.domain.usecase.GetFoodsByCategory
import com.example.k2p.domain.usecase.GetFoodsByName
import com.example.k2p.domain.usecase.SaveFoods
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class FoodViewModel @Inject constructor(
    private val getFoodsByCategory: GetFoodsByCategory,
    private val getFoodsByName: GetFoodsByName,
    private val saveFoods: SaveFoods) :
    BaseViewModel() {

    fun doGetFoodsByCategory(category: String){
        getFoodsByCategory(category){
            it.fold(::handleFailure){
                state.value = FoodViewState.FoodsReceived(it.meals ?: listOf())

                saveFoods(it.meals ?: listOf())

                true
            }
        }
    }

    fun doGetFoodsByName(name: String){
        getFoodsByName(name){
            it.fold(::handleFailure){
                state.value = FoodViewState.FoodsReceived(it.meals ?: listOf())

                saveFoods(it.meals ?: listOf())

                true
            }
        }
    }

    private fun saveFoods(foods: List<Food>){
        saveFoods(foods){
            it.fold(::handleFailure){
                it
            }
        }
    }

}