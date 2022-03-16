package com.bridgewaterlabs.news.ui.onboarding.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    var firstName = MutableLiveData<String>("")
    var lastName = MutableLiveData<String>("")
    var email = MutableLiveData<String>("")
    var password = MutableLiveData<String>("")
    var confirmPassword = MutableLiveData<String>("")
    var isChecked = MutableLiveData<Boolean>(false)

    var button = checkRegistration()

    private fun checkRegistration(): LiveData<Boolean> {
        var firstname = false
        var lastname = false
        var emailCheck = false
        var passwordCheck = false
        var confirmPasswordCheck = false
        var checked = false
        fun checkResult() =
            firstname && lastname && emailCheck && passwordCheck && confirmPasswordCheck && checked

        val result = MediatorLiveData<Boolean>()

        result.addSource(firstName) {
            if (it != "") {
                firstname = true
            }
            result.value = checkResult()
        }
        result.addSource(lastName) {
            if (it != "") {
                lastname = true
            }
            result.value = checkResult()
        }
        result.addSource(email) {
            if (it != "") {
                emailCheck = true
            }
            result.value = checkResult()
        }
        result.addSource(password) {
            if (it != "") {
                passwordCheck = true
            }
            result.value = checkResult()
        }
        result.addSource(confirmPassword) {
            if (it != "") {
                confirmPasswordCheck = true
            }
            result.value = checkResult()
        }
        result.addSource(isChecked) {
            checked = it
            result.value = checkResult()
        }

        return result
    }
}
