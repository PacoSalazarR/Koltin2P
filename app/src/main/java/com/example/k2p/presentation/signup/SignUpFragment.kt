package com.example.k2p.presentation.signup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import com.example.k2p.databinding.SignUpFragmentBinding
import com.example.k2p.domain.model.User
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class SignUpFragment : BaseFragment(R.layout.sign_up_fragment) {


    private lateinit var binding: SignUpFragmentBinding
    private val signUpViewModel by viewModels<SignUpViewModel>()
    private var listUsers: MutableList<User> = mutableListOf()
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        signUpViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
        user = User(0,"","")
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when(state){
            is UserViewState.UsersReceived -> {
                if(checkUserList(state.users))
                    showToast("This user already exists")
                else
                    signUp()
            }
        }
    }

    private fun signUp(){
        user.apply {
            userName = binding.txtSignUpName.text.toString()
            password = binding.txtSignUpPassword.text.toString()
        }
        listUsers.add(user)
        signUpViewModel.saveUsers(listUsers)
        listUsers = mutableListOf()
        navController.navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
    }

    private fun checkUserList(users: List<User>): Boolean{
        return users.isNotEmpty()
    }

    private fun checkFields(): Boolean{
        return (binding.txtSignUpName.text.isNotBlank()&&binding.txtSignUpPassword.text.isNotBlank())
    }

    override fun setBinding(view: View) {
        binding = SignUpFragmentBinding.bind(view)


        binding.btnSignUp.setOnClickListener {

            if(checkFields()){
                signUpViewModel.doGetUserByName(binding.txtSignUpName.text.toString())
            }else{
                showToast("Some fields are missing")
            }
        }

        binding.txtGoToLogIn.setOnClickListener {
            navController.navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
        }
    }
}