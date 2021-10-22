package com.example.k2p.data.source

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.platform.NetworkHandler
import com.example.k2p.data.api.MealApi
import com.example.k2p.data.dto.CategoriesResponse
import com.example.k2p.domain.repository.CategoryRepository
import com.example.k2p.framework.api.ApiRequest
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val mealApi: MealApi,
    private val networkHandler: NetworkHandler
    ):
    CategoryRepository, ApiRequest {
    override fun getAllCategories() = makeRequest(
            networkHandler, mealApi.getAllCategories(), { it }, CategoriesResponse(
                emptyList()
            )
    )


}