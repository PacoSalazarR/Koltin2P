package com.example.k2p.presentation.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.k2p.R
import com.example.k2p.core.extension.failure
import com.example.k2p.core.extension.observe
import com.example.k2p.core.presentation.BaseFragment
import com.example.k2p.core.presentation.BaseViewState
import com.example.k2p.databinding.LoginFragmentBinding
import com.example.k2p.domain.model.User
import com.example.k2p.presentation.signup.SignUpFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@AndroidEntryPoint
@WithFragmentBindings
class LoginFragment : BaseFragment(R.layout.login_fragment) {

    private lateinit var binding: LoginFragmentBinding
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when(state){
            is LoginViewState.UsersReceived -> {
                if(checkUserList(state.users))
                    checkPassword(state.users[0])
                else
                    showToast("User not found")
            }
        }
    }

    private fun checkPassword(user: User){
        if(user.password == binding.txtPassword.text.toString())
            logIn(user)
        else
            showToast("Incorrect password")
    }

    private fun logIn(user: User){
        loginViewModel.doSaveLocalUser(user)
        navController.navigate(LoginFragmentDirections.actionLoginFragmentToAccountFragment())
    }

    private fun checkUserList(users: List<User>): Boolean{
        return users.isNotEmpty()
    }

    private fun checkFields(): Boolean{
        return (binding.txtUserName.text.isNotBlank()&&binding.txtPassword.text.isNotBlank())
    }

    override fun setBinding(view: View) {
        binding = LoginFragmentBinding.bind(view)

        binding.txtGoToSignUp.setOnClickListener {
            navController.navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }

        binding.btnLogin.setOnClickListener {
            if(checkFields()){
                loginViewModel.doGetUserByName(binding.txtUserName.text.toString())
            }else{
                showToast("Some fields are missing")
            }
            //navController.navigate(LoginFragmentDirections.actionLoginFragmentToAccountFragment())
        }
    }

}