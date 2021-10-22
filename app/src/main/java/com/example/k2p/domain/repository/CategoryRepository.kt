package com.example.k2p.domain.repository

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.data.dto.CategoriesResponse

interface CategoryRepository {

    fun getAllCategories(): Either<Failure, CategoriesResponse>
}