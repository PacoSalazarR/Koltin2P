package com.example.k2p.domain.usecase

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.core.platform.AuthManager
import javax.inject.Inject

class DeleteLocalUser @Inject constructor(private val authManager: AuthManager) :
UseCase<Boolean, UseCase.None>(){
    override suspend fun run(params: None): Either<Failure, Boolean> {
        authManager.user = null
        return authManager.user.let {
            Either.Right(true)
        } ?: Either.Left(Failure.Unauthorized)
    }
}