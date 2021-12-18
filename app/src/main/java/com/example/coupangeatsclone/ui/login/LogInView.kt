package com.example.coupangeatsclone.ui.login

import com.example.coupangeatsclone.data.remote.auth.Auth
import com.example.coupangeatsclone.data.remote.auth.UserInfo

interface LogInView {
    fun onPostLogInSuccess(response : UserInfo)
    fun onPostLogInLoading()
    fun onPostLogInFailure(code : Int, message : String)
}