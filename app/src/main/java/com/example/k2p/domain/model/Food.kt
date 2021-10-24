package com.example.k2p.domain.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
class Food (
    val idMeal: Int = 0,
    @Json(name = "strMeal") val mealName: String = "",
    @Json(name = "strCategory") val mealCategory: String? = "",
    @Json(name = "strArea") val area: String? = "",
    @Json(name = "strInstructions") val instructions: String? = "",
    @Json(name = "strMealThumb") val urlMealThumb: String = ""
        ): Parcelable
{
}