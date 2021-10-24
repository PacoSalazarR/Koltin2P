package com.example.k2p.data.dto

import com.example.k2p.domain.model.Food
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FoodResponse(val food: Food? = Food())