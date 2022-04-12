package com.example.food_delivery

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore


class Data_Store (val context: Context) {
    val Context.dataUser : DataStore<Preferences> by preferencesDataStore("user_prefs")

    companion object{
        var USER_NAME_KEY = toString()
        var USER_EMAIL_KEY = toString()
        var USER_PASS_KEY = toString()
        var USER_PHONE_KEY = toString()

    }

    suspend fun changedataUser(name: String, email: String, pass: String){
        context.dataUser.edit {
            USER_NAME_KEY = name
            USER_EMAIL_KEY = email
            USER_PASS_KEY = pass
            USER_PHONE_KEY = "0369321630"
        }
    }
}

class _DataStore private constructor(var name : String, var email: String, var password: String){
    companion object{
        private var instance : User? = null
        operator fun invoke(fullName : String, email: String, password: String):User = synchronized(this){
            if(instance == null || (!fullName.equals("") && !email.equals("") && !password.equals("")))
                instance = User(fullName,email,password)
            return instance as User
        }
    }
}