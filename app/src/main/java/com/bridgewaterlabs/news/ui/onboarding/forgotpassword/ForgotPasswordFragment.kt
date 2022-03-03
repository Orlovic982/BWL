package com.bridgewaterlabs.news.ui.onboarding.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.databinding.FragmentForgotpasswordBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment

class ForgotPasswordFragment : BaseFragment() {

    private lateinit var binding: FragmentForgotpasswordBinding
    private lateinit var viewModel: ForgotPasswordViewModel
    private val action = ForgotPasswordFragmentDirections.actionForgotPasswordToResetPassword()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotpasswordBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ForgotPasswordViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnForgotPassword.setOnClickListener {
            findNavController().navigate(action)
        }

        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }
}
