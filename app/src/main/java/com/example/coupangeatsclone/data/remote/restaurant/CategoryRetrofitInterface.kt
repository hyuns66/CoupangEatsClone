package com.example.coupangeatsclone.data.remote.restaurant

import com.example.coupangeatsclone.data.remote.auth.AuthResponse
import retrofit2.Call
import retrofit2.http.GET

interface CategoryRetrofitInterface {

    @GET("home/restCategory")
    fun getCategory() : Call<CategoryResponse>
}