package com.example.coupangeatsclone.data.remote.auth

import com.google.gson.annotations.SerializedName

data class UserInfo(@SerializedName("userId") val userIdx : Int,
                    @SerializedName("name") val name : String,
                    @SerializedName("phoneNumber") val phoneNumber : String,
                    @SerializedName("jwt") val jwt : String)

data class LogInResponse(
                     @SerializedName("result")val result : UserInfo?,
                     @SerializedName("isSuccess")val isSuccess : Boolean,
                     @SerializedName("code")val code : Int,
                     @SerializedName("message")val message : String)

data class Auth(@SerializedName("userId")val userIdx : Int,
                @SerializedName("jwt")val jwt : String)

data class AuthResponse(
                        @SerializedName("result")val result : Auth?,
                        @SerializedName("isSuccess")val isSuccess : Boolean,
                        @SerializedName("code")val code : Int,
                        @SerializedName("message")val message : String)