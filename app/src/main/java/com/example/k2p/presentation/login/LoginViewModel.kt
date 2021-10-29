package com.example.k2p.presentation.login

import androidx.lifecycle.ViewModel
import com.example.k2p.core.exception.Failure
import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.model.User
import com.example.k2p.domain.usecase.GetUserByName
import com.example.k2p.domain.usecase.SaveLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserByName: GetUserByName,
    private val saveLocalUser: SaveLocalUser) :
    BaseViewModel() {

        fun doGetUserByName(name: String){
            getUserByName(name){
                it.fold(::handleFailure) {
                    state.value = LoginViewState.UsersReceived(it.users?: listOf())
                    true
                }
            }
        }

        fun doSaveLocalUser(user: User){
            saveLocalUser(user)
        }

}