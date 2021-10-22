package com.example.k2p.domain.usecase

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.data.dto.CategoriesResponse
import com.example.k2p.domain.repository.CategoryRepository
import javax.inject.Inject

class GetAllCategories @Inject constructor(private val categoryRepository: CategoryRepository) : UseCase<CategoriesResponse, String>(){
    override suspend fun run(params: String) = categoryRepository.getAllCategories()

}