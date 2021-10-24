package com.example.k2p.domain.repository

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.data.dto.FoodResponse
import com.example.k2p.data.dto.FoodsResponse

interface FoodRepository {

    fun getFoodsByCategory(category: String): Either<Failure, FoodsResponse>

    fun getRandomFood(): Either<Failure, FoodResponse>
}