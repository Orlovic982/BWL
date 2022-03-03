package com.bridgewaterlabs.news.ui.onboarding.resetpassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResetPasswordViewModel : ViewModel() {
    var email = MutableLiveData<String>("")
    var password = MutableLiveData<String>("")
}
