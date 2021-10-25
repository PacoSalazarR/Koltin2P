package com.example.k2p.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
class User (
    @PrimaryKey(autoGenerate = true)
    val idUser: Int = 0,
    val userName: String = "",
    val mail: String = "",
    val img: String = "",
    val token: String = ""
) {
}