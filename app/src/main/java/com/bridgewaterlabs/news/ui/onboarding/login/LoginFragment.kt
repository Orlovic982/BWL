package com.bridgewaterlabs.news.ui.onboarding.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.databinding.FragmentLoginBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment
import com.bridgewaterlabs.news.ui.main.MainActivity
import com.bridgewaterlabs.news.util.ResourceWrapper
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment() : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel

        setupNavigation()
        setupLogin()

        return binding.root
    }

    fun setupLogin() {
        binding.btnLogin.setOnClickListener() {
                  viewModel.login(viewModel.email.value.toString(), viewModel.password.value.toString())
        }

        viewModel.loginState.observe(
            viewLifecycleOwner,
            Observer {
                when (it) {
                    is LoginState.Success -> navigateHome()
                    is LoginState.InvalidCredentials->
                    {
                        toast(getString(R.string.invalid_username_or_password))
                    }
                    is LoginState.Error -> {
                        toast(it.message)
                    }
                    else -> {}
                }
            }
        )
    }


    fun setupNavigation() {
        binding.tvForgotPassword.setOnClickListener() {
            val action = LoginFragmentDirections.actionLoginToForgotPasswordFragment()
            findNavController().navigate(action)
        }

        binding.btnRegister.setOnClickListener() {
            val action = LoginFragmentDirections.actionLoginToRegisterFragment()
            findNavController().navigate(action)
        }
    }

    fun navigateHome() {
        Intent(requireContext(), MainActivity::class.java).also {
            startActivity(it)
        }
    }

    fun toast(message:String){
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

}
