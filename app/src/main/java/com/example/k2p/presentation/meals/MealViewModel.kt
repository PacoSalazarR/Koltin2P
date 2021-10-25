package com.example.k2p.presentation.meals

import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.model.Category
import com.example.k2p.domain.usecase.GetAllCategories
import com.example.k2p.domain.usecase.SaveCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class MealViewModel @Inject constructor(
    private val getAllCategories: GetAllCategories,
    private val saveCategories: SaveCategories) :
    BaseViewModel() {

    fun doGetAllCategories(){
        getAllCategories(""){
            it.fold(::handleFailure){
                state.value = MealViewState.CategoriesReceived(it.categories ?: listOf())

                saveCategories(it.categories ?: listOf())

                true
            }
        }
    }

    private fun saveCategories(categories: List<Category>){
        saveCategories(categories) {
            it.fold(::handleFailure){
                it
            }
        }
    }

}