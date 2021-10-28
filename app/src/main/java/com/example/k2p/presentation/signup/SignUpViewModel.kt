package com.example.k2p.presentation.signup

import androidx.lifecycle.ViewModel
import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.model.User
import com.example.k2p.domain.usecase.SaveUsers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class SignUpViewModel @Inject constructor(
private val saveUsers: SaveUsers
) : BaseViewModel() {

    fun saveUsers(users: List<User>){
        saveUsers(users){
            it.fold(::handleFailure){
                it
            }
        }
    }
}