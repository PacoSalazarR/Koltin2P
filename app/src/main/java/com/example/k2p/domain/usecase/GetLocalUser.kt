package com.example.k2p.domain.usecase

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.core.platform.AuthManager
import com.example.k2p.domain.model.User
import javax.inject.Inject

class GetLocalUser @Inject constructor(private val authManager: AuthManager) :
    UseCase<User, UseCase.None>(){
    override suspend fun run(params: None): Either<Failure, User> {
        val result = authManager.user

        return result?.let {
            Either.Right(it)
        } ?: Either.Left(Failure.Unauthorized)
    }
}