package com.example.food_delivery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//class Resp (var isSuccess :Boolean, var error:Error?)
class profile_view_model: ViewModel() {
    private var _isSuccessEvent:MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent :LiveData<Boolean>
        get()= _isSuccessEvent

    private var _isErrorEvent:MutableLiveData<String> = MutableLiveData()
    val isErrorEvent :LiveData<String>
        get()= _isErrorEvent
    fun checkEmail(email: String) {
        val isValidEmail = isEmailValid(email)
        if (!isValidEmail) {
            _isErrorEvent.postValue("Ivalid email")
            return
        }
        _isSuccessEvent.postValue(true)
    }
    fun checkEmailAndPassword (email:String,password:String){
        val isValidEmail = isEmailValid(email)
        val isValidPhoneNumber= isPhoneNumberValid(password)
        if(!isValidEmail){
            _isErrorEvent.postValue("Ivalid email")
            return
        }
        if(!isValidPhoneNumber){
            _isErrorEvent.postValue("Ivalid password")
            return
        }
        return _isSuccessEvent.postValue(true)
    }

    private fun isEmailValid(email: String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPhoneNumberValid(password: String):Boolean{
        return password.length>5 && password.length<10
    }
}