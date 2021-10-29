package com.example.k2p.domain.repository

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.data.dto.LikesResponse
import com.example.k2p.domain.model.Like

interface LikeRepository {

    fun getLikesByUserId(id: String): Either<Failure, LikesResponse>

    fun getLikesByMealId(id: String): Either<Failure, LikesResponse>

    fun saveLike(likes: List<Like>): Either<Failure, Boolean>

    fun deleteLike(id: String): Either<Failure, Boolean>
}