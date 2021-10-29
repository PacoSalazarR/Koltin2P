package com.example.k2p.domain.repository

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.data.dto.UserResponse
import com.example.k2p.domain.model.User

interface UserRepository {

    fun getUserByName(name: String): Either<Failure, UserResponse>

    fun getAllUsers(): Either<Failure, UserResponse>

    fun saveUser(users: List<User>): Either<Failure, Boolean>
}