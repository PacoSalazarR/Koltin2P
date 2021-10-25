package com.example.k2p.domain.usecase

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.domain.model.Category
import com.example.k2p.domain.repository.CategoryRepository
import javax.inject.Inject

class SaveCategories @Inject constructor(private val categoryRepository: CategoryRepository): UseCase<Boolean, List<Category>>(){
    override suspend fun run(params: List<Category>) = categoryRepository.saveCategories(params)
}