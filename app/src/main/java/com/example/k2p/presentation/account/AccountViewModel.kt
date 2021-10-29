package com.example.k2p.presentation.account

import androidx.lifecycle.ViewModel
import com.example.k2p.core.exception.Failure
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.usecase.GetLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class AccountViewModel @Inject constructor(private val getLocalUser: GetLocalUser) :
    BaseViewModel() {

        fun getLocalUser(){
            getLocalUser(UseCase.None()){
                it.fold(::userNotFound) {
                    state.value = AccountViewState.LoggedUser(it)

                    true
                }
            }
        }

    private fun userNotFound(failure: Failure) {
        state.value = AccountViewState.UserNotFound
        handleFailure(failure)
    }
}