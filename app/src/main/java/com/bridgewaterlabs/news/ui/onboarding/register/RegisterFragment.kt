package com.bridgewaterlabs.news.ui.onboarding.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.databinding.FragmentForgotpasswordBinding
import com.bridgewaterlabs.news.databinding.FragmentRegisterBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment
import com.bridgewaterlabs.news.ui.common.successregister.SuccessRegisterDialogFragment
import com.bridgewaterlabs.news.ui.common.successreset.SuccessResetDialogFragment
import com.bridgewaterlabs.news.ui.onboarding.forgotpassword.ForgotPasswordViewModel

class RegisterFragment : BaseFragment() {
    lateinit var binding: FragmentRegisterBinding
    lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnResetPassword.setOnClickListener() {
            val dialog = SuccessRegisterDialogFragment()
            dialog.show(childFragmentManager, "Success")
        }

        binding.ivBack.setOnClickListener() {
            findNavController().navigateUp()
        }

        return binding.root
    }
}