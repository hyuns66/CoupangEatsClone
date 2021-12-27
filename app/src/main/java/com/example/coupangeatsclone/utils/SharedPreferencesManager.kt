package com.example.coupangeatsclone.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.coupangeatsclone.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.coupangeatsclone.ApplicationClass.Companion.mSharedPreferences

fun saveJwt(jwt : String){
    val editor = mSharedPreferences.edit()
    editor.putString(X_ACCESS_TOKEN, jwt)

    editor.apply()
}

fun getJwt(): String? = mSharedPreferences.getString(X_ACCESS_TOKEN, null)

fun saveName(name : String){
    val editor = mSharedPreferences.edit()
    editor.putString("userName", name)
    editor.apply()
}

fun getName() : String = mSharedPreferences.getString("userName", "(알 수 없음)")!!

fun savePhoneNumber(phone : String){
    val editor = mSharedPreferences.edit()
    editor.putString("userPhone", phone)
    editor.apply()
}

fun getPhoneNumber() : String = mSharedPreferences.getString("userPhone", "(알 수 없음)")!!