package com.bridgewaterlabs.news.ui.onboarding.resetpassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResetPasswordViewModel : ViewModel() {
    var password = MutableLiveData<String>("")
    var newPassword = MutableLiveData<String>("")
}
