package com.example.k2p.data.source

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.data.dao.FoodDao
import com.example.k2p.data.dto.LikesResponse
import com.example.k2p.domain.model.Like
import com.example.k2p.domain.repository.LikeRepository
import javax.inject.Inject

class LikeRepositoryImpl @Inject constructor(
    private val foodDao: FoodDao
): LikeRepository {
    override fun getLikesByUserId(id: String): Either<Failure, LikesResponse> {
        val localResult = foodDao.getUserLikes("%$id%")
        return  Either.Right(LikesResponse(localResult))
    }

    override fun getLikesByMealId(id: String): Either<Failure, LikesResponse> {
        val localResult = foodDao.getLikesByMealId("%$id%")
        return Either.Right(LikesResponse(localResult))
    }

    override fun saveLike(likes: List<Like>): Either<Failure, Boolean> {
        val result = foodDao.saveLike(likes)
        return if (result.size == likes.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }

    override fun deleteLike(id: String): Either<Failure, Boolean> {
        val result = foodDao.deleteLike(id)
        return if (result == 1) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }
}