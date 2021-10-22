package com.example.k2p.data.dto

import com.example.k2p.domain.model.Category
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoriesResponse(val categories: List<Category>? = listOf())
