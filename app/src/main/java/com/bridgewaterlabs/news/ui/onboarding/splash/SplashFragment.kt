package com.bridgewaterlabs.news.ui.onboarding.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bridgewaterlabs.news.databinding.FragmentSplashBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment

class SplashFragment : BaseFragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}
