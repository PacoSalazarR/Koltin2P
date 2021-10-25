package com.example.k2p.data.source

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.platform.NetworkHandler
import com.example.k2p.data.api.MealApi
import com.example.k2p.data.dao.FoodDao
import com.example.k2p.data.dto.CategoriesResponse
import com.example.k2p.domain.model.Category
import com.example.k2p.domain.repository.CategoryRepository
import com.example.k2p.framework.api.ApiRequest
import java.util.*
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val mealApi: MealApi,
    private val foodDao: FoodDao,
    private val networkHandler: NetworkHandler
    ):
    CategoryRepository, ApiRequest {
    override fun getAllCategories() : Either<Failure, CategoriesResponse> {
        var result = makeRequest(networkHandler, mealApi.getAllCategories(), { it }, CategoriesResponse(emptyList()))

        return if(result.isLeft){
            val localResult = foodDao.getAllCategories()

            if(localResult.isEmpty()) result
            else Either.Right(CategoriesResponse(localResult))
        } else result
    }

    override fun saveCategories(categories: List<Category>): Either<Failure, Boolean> {
        val result = foodDao.saveCategories(categories)
        return if (result.size == categories.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }

}