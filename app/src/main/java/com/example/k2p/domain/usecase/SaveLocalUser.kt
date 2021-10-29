package com.example.k2p.domain.usecase

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.core.platform.AuthManager
import com.example.k2p.domain.model.User
import javax.inject.Inject

class SaveLocalUser @Inject constructor(private val authManager: AuthManager) :
UseCase<Boolean, User>(){
    override suspend fun run(params: User): Either<Failure, Boolean> {
        authManager.user = params
        return authManager.user?.let {
            Either.Right(true)
        } ?: Either.Left(Failure.Unauthorized)
    }

}