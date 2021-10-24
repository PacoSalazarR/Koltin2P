package com.example.k2p.domain.usecase

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.data.dto.FoodResponse
import com.example.k2p.data.dto.FoodsResponse
import com.example.k2p.domain.repository.FoodRepository
import javax.inject.Inject

class GetRandomFood @Inject constructor(private val foodRepository: FoodRepository) :
    UseCase<FoodResponse, String>() {
    override suspend fun run(params: String) = foodRepository.getRandomFood()
}