package com.example.k2p.presentation.signup

import androidx.lifecycle.ViewModel
import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.model.User
import com.example.k2p.domain.usecase.GetAllUsers
import com.example.k2p.domain.usecase.GetUserByName
import com.example.k2p.domain.usecase.SaveUsers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class SignUpViewModel @Inject constructor(
private val saveUsers: SaveUsers,
private val getAllUsers: GetAllUsers,
private val getUserByName: GetUserByName
) : BaseViewModel() {


    fun saveUsers(users: List<User>){
        saveUsers(users){
            it.fold(::handleFailure){
                it
            }
        }
    }

    fun doGetUserByName(name: String){
        getUserByName(name){
            it.fold(::handleFailure){
                state.value = UserViewState.UsersReceived(it.users?: listOf())
                true
            }
        }
    }

    fun doGetAllUsers(){
        getAllUsers(""){
            it.fold(::handleFailure){
                state.value = UserViewState.UsersReceived(it.users ?: listOf())
                true
            }
        }
    }
}