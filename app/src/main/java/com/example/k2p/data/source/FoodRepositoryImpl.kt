package com.example.k2p.data.source

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.platform.NetworkHandler
import com.example.k2p.data.api.MealApi
import com.example.k2p.data.dao.FoodDao
import com.example.k2p.data.dto.FoodResponse
import com.example.k2p.data.dto.FoodsResponse
import com.example.k2p.domain.model.Food
import com.example.k2p.domain.repository.FoodRepository
import com.example.k2p.framework.api.ApiRequest
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val mealApi: MealApi,
    private val foodDao: FoodDao,
    private val networkHandler: NetworkHandler
    ):
    FoodRepository, ApiRequest {
    override fun getFoodsByCategory(category: String) : Either<Failure, FoodsResponse>{
        val result = makeRequest(networkHandler, mealApi.getFoodsByCategory(category), { it }, FoodsResponse(emptyList()))

        return if (result.isLeft){
            val localResult = foodDao.getFoodsByCategory("%$category%")

            if (localResult.isEmpty()) result
            else Either.Right(FoodsResponse(localResult))
        } else result
    }

    override fun getFoodsByName(name: String): Either<Failure, FoodsResponse>{
        val result = makeRequest(networkHandler, mealApi.getFoodsByName(name), {it}, FoodsResponse(emptyList()))

        return if (result.isLeft){
            val localResult = foodDao.getFoodsByName("%$name%")

            if(localResult.isEmpty()) result
            else Either.Right(FoodsResponse(localResult))
        } else result
    }

    override fun getFoodById(id: String): Either<Failure, FoodsResponse> {
        val result = makeRequest(networkHandler, mealApi.getFoodById(id), { it }, FoodsResponse(emptyList()))

        return if (result.isLeft){
            val localResult = foodDao.getFoodsById("%$id%")

            if(localResult.isEmpty()) result
            else Either.Right(FoodsResponse(localResult))
        } else result
    }

    override fun getRandomFood() = makeRequest(networkHandler, mealApi.getRandomFood(), {it}, FoodsResponse(emptyList()))

    override fun saveFoods(foods: List<Food>): Either<Failure, Boolean> {
        val result = foodDao.saveFoods(foods)
        return if (result.size == foods.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }

}