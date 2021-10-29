package com.example.k2p.presentation.account

import com.example.k2p.core.presentation.BaseViewState
import com.example.k2p.domain.model.User

abstract class AccountViewState : BaseViewState() {
    data class LoggedUser(val user: User) : BaseViewState()
    object UserNotFound : BaseViewState()
}