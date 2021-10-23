package com.example.k2p.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class Food (
    val idMeal: Int,
    @Json(name = "strMeal") val mealName: String = "",
    @Json(name = "strCategory") val mealCategory: String? = "",
    @Json(name = "strArea") val area: String? = "",
    @Json(name = "strInstructions") val instructions: String? = "",
    @Json(name = "strMealThumb") val urlMealThumb: String = ""
        )
{
}