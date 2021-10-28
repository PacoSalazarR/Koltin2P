package com.example.k2p.domain.repository

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.domain.model.User

interface UserRepository {
    fun saveUser(users: List<User>): Either<Failure, Boolean>
}