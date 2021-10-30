package com.example.k2p.presentation.mealdetail

import com.example.k2p.core.presentation.BaseViewState
import com.example.k2p.domain.model.Like

sealed class LikeViewState: BaseViewState(){
    data class LikesReceived(val likes: List<Like>): BaseViewState()
}
