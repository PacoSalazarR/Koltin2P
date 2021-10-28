package com.example.k2p.data.dto

import com.example.k2p.domain.model.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(val users: List<User>? = listOf())