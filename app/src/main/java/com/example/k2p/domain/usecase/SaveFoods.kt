package com.example.k2p.domain.usecase

import com.example.k2p.core.interactor.UseCase
import com.example.k2p.domain.model.Food
import com.example.k2p.domain.repository.FoodRepository
import javax.inject.Inject

class SaveFoods @Inject constructor(private val foodRepository: FoodRepository) : UseCase<Boolean, List<Food>>() {
    override suspend fun run(params: List<Food>) = foodRepository.saveFoods(params)
}