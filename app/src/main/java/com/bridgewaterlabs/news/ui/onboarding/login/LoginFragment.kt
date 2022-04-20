package com.bridgewaterlabs.news.ui.onboarding.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.databinding.FragmentLoginBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment
import com.bridgewaterlabs.news.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {
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

        viewModel.successLogin.observe(
            viewLifecycleOwner,
            Observer {
                if (it == true) {
                    Toast.makeText(context, "Welcome", Toast.LENGTH_SHORT).show()
                    Intent(requireContext(), MainActivity::class.java).also {
                        startActivity(it)
                    }
                }
            }
        )
        viewModel.failureLogin.observe(
            viewLifecycleOwner,
            Observer {
                if (it == true) {
                    Toast.makeText(context, "Email or password are not valid", Toast.LENGTH_SHORT).show()
                    viewModel.email.value = ""
                    viewModel.password.value = ""
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
}
