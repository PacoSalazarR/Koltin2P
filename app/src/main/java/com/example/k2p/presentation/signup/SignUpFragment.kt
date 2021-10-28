package com.example.k2p.presentation.signup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.k2p.R
import com.example.k2p.core.presentation.BaseFragment
import com.example.k2p.databinding.SignUpFragmentBinding
import com.example.k2p.domain.model.User
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class SignUpFragment : BaseFragment(R.layout.sign_up_fragment) {

    private lateinit var user: User
    private lateinit var binding: SignUpFragmentBinding
    private val signUpViewModel by viewModels<SignUpViewModel>()
    private var listUsers: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        user = User(0,"","")
        showToast("Inicio")
    }

    override fun setBinding(view: View) {
        binding = SignUpFragmentBinding.bind(view)

        binding.btnSignUp.setOnClickListener {
            if(binding.txtSignUpName.text.isNotEmpty()&&binding.txtSignUpPassword.text.isNotEmpty()){
                user.apply {
                    userName = binding.txtSignUpName.text.toString()
                    password = binding.txtSignUpPassword.text.toString()
                }
                listUsers.add(user)
                signUpViewModel.saveUsers(listUsers)
                listUsers.remove(user)
            }else{
                showToast("hola")
            }
        }

        binding.txtGoToLogIn.setOnClickListener {
            navController.navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
        }
    }


}