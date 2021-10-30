package com.example.k2p.domain.usecase

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.functional.Either
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.domain.repository.LikeRepository
import com.facebook.appevents.PerformanceGuardian
import javax.inject.Inject

class DeleteLike @Inject constructor(private val likeRepository: LikeRepository): UseCase<Boolean, String>() {
    override suspend fun run(params: String) = likeRepository.deleteLike(params)

}