package com.example.coupangeatsclone.data.remote.restaurant

import android.util.Log
import com.example.coupangeatsclone.ApplicationClass.Companion.retrofit
import com.example.coupangeatsclone.data.remote.auth.AuthResponse
import com.example.coupangeatsclone.data.remote.auth.AuthRetrofitInterface
import com.example.coupangeatsclone.ui.main.home.CategoryView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class CategoryService {

    private lateinit var categoryView : CategoryView

    fun setCategoryView(categoryView: CategoryView){
        this.categoryView = categoryView
    }

    fun getCategory(){
        val categoryService = retrofit.create(CategoryRetrofitInterface::class.java)
        categoryService.getCategory().enqueue(object : retrofit2.Callback<CategoryResponse>{
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {

                val resp = response.body()!!
                when(resp.code){
                    1000 -> categoryView.onGetCategorySuccess(resp.result!!)
                    else -> categoryView.onGetCategoryFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Log.d("SIGNUP/FAILURE", t.toString())

                categoryView.onGetCategoryFailure(400, "네트워크 오류가 발생했습니다.")
            }

        })
    }
}