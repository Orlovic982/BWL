package com.bridgewaterlabs.news.ui.onboarding.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.databinding.FragmentForgotpasswordBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment
import com.bridgewaterlabs.news.ui.onboarding.splash.SplashFragmentDirections

class ForgotPasswordFragment : BaseFragment() {

    private lateinit var binding: FragmentForgotpasswordBinding

    private val action = ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToResetPasswordFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentForgotpasswordBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.btnForgotPassword.setOnClickListener(){
            findNavController().navigate(action)
        }


        return binding.root



    }



}