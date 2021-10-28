package com.example.k2p.domain.usecase

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.domain.model.User
import com.example.k2p.domain.repository.UserRepository
import javax.inject.Inject

class SaveUsers @Inject constructor(private val userRepository: UserRepository) : UseCase<Boolean, List<User>>() {
    override suspend fun run(params: List<User>) = userRepository.saveUser(params)
}