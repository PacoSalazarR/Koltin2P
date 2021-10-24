package com.example.k2p.data.source

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.platform.NetworkHandler
import com.example.k2p.data.api.MealApi
import com.example.k2p.data.dto.FoodResponse
import com.example.k2p.data.dto.FoodsResponse
import com.example.k2p.domain.model.Food
import com.example.k2p.domain.repository.FoodRepository
import com.example.k2p.framework.api.ApiRequest
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val mealApi: MealApi,
    private val networkHandler: NetworkHandler
    ):
    FoodRepository, ApiRequest {
    override fun getFoodsByCategory(category: String) = makeRequest(
        networkHandler, mealApi.getFoodsByCategory(category), { it }, FoodsResponse(
                emptyList()
        )
    )

    override fun getRandomFood() = makeRequest(
        networkHandler, mealApi.getRandomFood(), {it}, FoodResponse(
            Food()
        )
    )

}