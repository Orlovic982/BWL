package com.bridgewaterlabs.news.ui.onboarding

import android.content.SharedPreferences
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bridgewaterlabs.news.R
import com.bridgewaterlabs.news.databinding.ActivityOnboardingBinding
import com.bridgewaterlabs.news.ui.common.BaseActivity

class OnboardingActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()

    }

    private fun setupBinding() {
        DataBindingUtil.setContentView<ActivityOnboardingBinding>(
            this,
            R.layout.activity_onboarding
        )
    }
}
