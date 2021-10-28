package com.example.k2p.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
@JsonClass(generateAdapter = true)
class User (
    @PrimaryKey(autoGenerate = true)
    val idUser: Int = 0,
    var userName: String = "",
    var password: String = ""
    //val mail: String = "",
    //val img: String = "",
    //val token: String = ""
): Parcelable {
}