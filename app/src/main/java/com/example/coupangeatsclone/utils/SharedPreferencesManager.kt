package com.example.coupangeatsclone.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.coupangeatsclone.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.coupangeatsclone.ApplicationClass.Companion.mSharedPreferences

fun saveJwt(jwt : String){
//    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
//    val editor = spf.edit()
//
//    editor.putString("jwt", jwt)
//    editor.apply()

    val editor = mSharedPreferences.edit()
    editor.putString(X_ACCESS_TOKEN, jwt)

    editor.apply()
}

//fun getJwt(context: Context): String{
//    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
//
//    return spf.getString("jwt", "")!!
//}

fun getJwt(): String? = mSharedPreferences.getString(X_ACCESS_TOKEN, null)

fun saveName(name : String){
    val editor = mSharedPreferences.edit()
    editor.putString(X_ACCESS_TOKEN, name)
    editor.apply()
}

fun getName() : String = mSharedPreferences.getString(X_ACCESS_TOKEN, "(알 수 없음)")!!

fun savePhoneNumber(phone : String){
    val editor = mSharedPreferences.edit()
    editor.putString(X_ACCESS_TOKEN, phone)
    editor.apply()
}

fun getPhoneNumber() : String = mSharedPreferences.getString(X_ACCESS_TOKEN, "(알 수 없음)")!!