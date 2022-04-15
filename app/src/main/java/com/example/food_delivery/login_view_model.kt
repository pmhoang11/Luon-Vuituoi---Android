package com.example.food_delivery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

enum class Error{
    ERROR_EMAIL,
    ERROR_PASSWORD,
}

//class Resp (var isSuccess :Boolean, var error:Error?)
class login_view_model: ViewModel() {
    private var _isSuccessEvent:MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent :LiveData<Boolean>
    get()= _isSuccessEvent

    private var _isErrorEvent:MutableLiveData<String> = MutableLiveData()
    val isErrorEvent :LiveData<String>
        get()= _isErrorEvent

    fun checkEmailAndPassword (email:String,password:String){
        val isvalidemail= isValidEmail(email)
        val isvalidpassword= isPasswordValid(password)
        if(!isvalidemail){
            _isErrorEvent.postValue("Ivalid email")
            return
        }
        if(!isvalidpassword){
            _isErrorEvent.postValue("Ivalid password")
            return
        }
        return _isSuccessEvent.postValue(true)
    }

    private fun isValidEmail(email: String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        if (password.length < 8){
            _isErrorEvent.postValue("Password with at least 8 characters")
            return false
        }
        val check = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]).{8,}\$")
        if (!check.matcher(password).matches()){
            _isErrorEvent.postValue("Password must contain uppercase, lowercase letters, numbers and special characters")
            return false
        }
        return true
    }
}