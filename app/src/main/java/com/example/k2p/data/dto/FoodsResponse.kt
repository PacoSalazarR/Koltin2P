package com.example.k2p.data.dto

import com.example.k2p.domain.model.Food
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FoodsResponse(val foods: List<Food>? = listOf())
