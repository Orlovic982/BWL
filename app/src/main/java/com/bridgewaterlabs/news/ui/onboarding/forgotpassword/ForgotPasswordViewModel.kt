package com.bridgewaterlabs.news.ui.onboarding.forgotpassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ForgotPasswordViewModel : ViewModel() {

    val email = MutableLiveData<String>()
    var isChecked = MutableLiveData<Boolean>()

    init {
        email.value = ""
        isChecked.value = false
    }
}
