package com.example.k2p.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
@JsonClass(generateAdapter = true)
class Like(
    @PrimaryKey(autoGenerate = true)
    val idLike: Int = 0,
    var idLikeFood: Int = 0,
    var idLikeUser: Int = 0
): Parcelable {
}