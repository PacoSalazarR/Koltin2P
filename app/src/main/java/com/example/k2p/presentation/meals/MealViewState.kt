package com.example.k2p.presentation.meals

import com.example.k2p.core.presentation.BaseViewState
import com.example.k2p.domain.model.Category

sealed class MealViewState: BaseViewState() {

    data class CategoriesReceived(val categories: List<Category>): BaseViewState()

}