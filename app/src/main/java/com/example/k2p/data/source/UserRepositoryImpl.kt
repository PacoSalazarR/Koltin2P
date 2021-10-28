package com.example.k2p.data.source

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.data.dao.FoodDao
import com.example.k2p.domain.model.User
import com.example.k2p.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val foodDao: FoodDao
): UserRepository {
    override fun saveUser(users: List<User>): Either<Failure, Boolean> {
        val result = foodDao.saveUser(users)
        return if (result.size == users.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }
}