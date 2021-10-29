package com.example.k2p.presentation.signup

import com.example.k2p.core.presentation.BaseViewState
import com.example.k2p.domain.model.User

sealed class UserViewState: BaseViewState(){
    data class UsersReceived(val users: List<User>): BaseViewState()
}
