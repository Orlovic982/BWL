package com.bridgewaterlabs.news.ui.onboarding.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    var firstName = MutableLiveData<String>("")
    var lastName = MutableLiveData<String>("")
    var email = MutableLiveData<String>("")
    var password = MutableLiveData<String>("")
    var confirmPassword = MutableLiveData<String>("")

}