package com.example.k2p.domain.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
class Category (
    val idCategory: Int,
    @Json(name = "strCategory") val category: String = "",
    @Json(name = "strCategoryDescription") val description: String = "",
    @Json(name = "strCategoryThumb") val urlThumb: String = ""
): Parcelable{

}