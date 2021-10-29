package com.example.k2p.domain.usecase

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.data.dto.UserResponse
import com.example.k2p.domain.repository.UserRepository
import javax.inject.Inject

class GetUserByName @Inject constructor(private val userRepository: UserRepository) :
UseCase<UserResponse, String>(){
    override suspend fun run(params: String) = userRepository.getUserByName(params)
}