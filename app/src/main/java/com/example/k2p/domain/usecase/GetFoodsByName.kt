package com.example.k2p.domain.usecase


import com.example.k2p.core.interactor.UseCase
import com.example.k2p.data.dto.FoodsResponse
import com.example.k2p.domain.repository.FoodRepository
import javax.inject.Inject

class GetFoodsByName @Inject constructor(private val foodRepository: FoodRepository) :
    UseCase<FoodsResponse, String>(){
    override suspend fun run(params: String) = foodRepository.getFoodsByName(params)
}