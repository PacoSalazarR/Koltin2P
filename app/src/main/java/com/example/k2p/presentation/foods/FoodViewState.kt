package com.example.k2p.presentation.foods

import com.example.k2p.core.presentation.BaseViewState
import com.example.k2p.domain.model.Food

sealed class FoodViewState: BaseViewState() {

    data class FoodsReceived(val meals: List<Food>): BaseViewState()

    data class FoodReceived(val food: Food): BaseViewState()
}