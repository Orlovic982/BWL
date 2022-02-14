package com.bridgewaterlabs.news.ui.onboarding.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bridgewaterlabs.news.databinding.FragmentLoginBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment

class LoginFragment : BaseFragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}
