package com.example.k2p.domain.usecase

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.domain.model.Like
import com.example.k2p.domain.repository.LikeRepository
import javax.inject.Inject

class SaveLikes @Inject constructor(private val likeRepository: LikeRepository) : UseCase<Boolean, List<Like>>() {
    override suspend fun run(params: List<Like>) = likeRepository.saveLike(params)
}