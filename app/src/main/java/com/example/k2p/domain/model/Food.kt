package com.example.k2p.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
@JsonClass(generateAdapter = true)
class Food (
    @PrimaryKey(autoGenerate = false)
    val idMeal: Int = 0,
    @Json(name = "strMeal") val mealName: String = "",
    @Json(name = "strCategory") val mealCategory: String? = "",
    @Json(name = "strArea") val area: String? = "",
    @Json(name = "strInstructions") val instructions: String? = "",
    @Json(name = "strMealThumb") val urlMealThumb: String = ""
        ): Parcelable
{
}