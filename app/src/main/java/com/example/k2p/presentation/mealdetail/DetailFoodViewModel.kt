package com.example.k2p.presentation.mealdetail

import androidx.lifecycle.ViewModel
import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.model.Food
import com.example.k2p.domain.usecase.GetFoodById
import com.example.k2p.domain.usecase.SaveFoods
import com.example.k2p.presentation.meals.FoodViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class DetailFoodViewModel @Inject constructor(
    private val getFoodById: GetFoodById,
    private val saveFoods: SaveFoods):
    BaseViewModel() {

        fun doGetFoodById(id: String){
            getFoodById(id){
                it.fold(::handleFailure){
                    state.value = FoodViewState.FoodsReceived(it.meals?: listOf())

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