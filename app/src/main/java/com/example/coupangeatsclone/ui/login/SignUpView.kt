package com.example.coupangeatsclone.ui.login

import com.example.coupangeatsclone.data.remote.auth.Auth
import com.example.coupangeatsclone.data.remote.auth.AuthResponse

interface SignUpView {
    fun onPostSignUpSuccess(response : Auth)
    fun onPostSignUpLoading()
    fun onPostSignUpFailure(code : Int, message : String)
}