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