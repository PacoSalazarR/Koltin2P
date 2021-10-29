package com.example.k2p.data.dto

import com.example.k2p.domain.model.Like
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LikesResponse(val likes: List<Like>? = listOf())
