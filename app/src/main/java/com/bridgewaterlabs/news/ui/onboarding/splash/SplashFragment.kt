package com.bridgewaterlabs.news.ui.onboarding.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bridgewaterlabs.news.databinding.FragmentSplashBinding
import com.bridgewaterlabs.news.ui.common.BaseFragment

class SplashFragment : BaseFragment() {
    private lateinit var binding: FragmentSplashBinding
    private val mhandler = Handler(Looper.getMainLooper())
    private val action = SplashFragmentDirections.actionSplashToLogin()
    private val navigateRunnable = Runnable { findNavController().navigate(action) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onPause() {
        super.onPause()
        mhandler.removeCallbacks(navigateRunnable)
    }

    override fun onResume() {
        super.onResume()
        mhandler.postDelayed(navigateRunnable, 2000)
    }
}
