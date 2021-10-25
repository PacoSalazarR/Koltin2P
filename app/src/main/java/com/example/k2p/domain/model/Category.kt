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
class Category (
    @PrimaryKey(autoGenerate = false)
    val idCategory: Int,
    @Json(name = "strCategory") val category: String = "",
    @Json(name = "strCategoryDescription") val description: String = "",
    @Json(name = "strCategoryThumb") val urlThumb: String = ""
): Parcelable{

}