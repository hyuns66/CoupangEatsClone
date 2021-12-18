package com.example.coupangeatsclone.data.remote.restaurant

import com.example.coupangeatsclone.data.remote.auth.Auth
import com.google.gson.annotations.SerializedName

data class Category(
        @SerializedName("categoryIdx") val categoryIdx : Int,
        @SerializedName("categoryName") val categoryName : String,
        @SerializedName("iconImgUrl") val iconImgUrl : String)


data class CategoryResponse(
        @SerializedName("result")val result : ArrayList<Category>?,
        @SerializedName("isSuccess")val isSuccess : Boolean,
        @SerializedName("code")val code : Int,
        @SerializedName("message")val message : String)