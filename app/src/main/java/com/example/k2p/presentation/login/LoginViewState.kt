package com.example.k2p.presentation.login

import com.example.k2p.core.presentation.BaseViewState
import com.example.k2p.domain.model.User

class LoginViewState: BaseViewState() {
    data class UsersReceived(val users: List<User>): BaseViewState()
}