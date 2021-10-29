package com.example.k2p.presentation.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.k2p.R
import com.example.k2p.core.presentation.BaseFragment
import com.example.k2p.databinding.LoginFragmentBinding
import com.example.k2p.presentation.signup.SignUpFragmentDirections

class LoginFragment : BaseFragment(R.layout.login_fragment) {

    private lateinit var binding: LoginFragmentBinding

    override fun setBinding(view: View) {
        binding = LoginFragmentBinding.bind(view)

        binding.txtGoToSignUp.setOnClickListener {
            navController.navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }

        binding.btnLogin.setOnClickListener {
            navController.navigate(LoginFragmentDirections.actionLoginFragmentToAccountFragment())
        }
    }

}