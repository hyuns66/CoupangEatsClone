package com.example.coupangeatsclone.ui.main.home

import com.example.coupangeatsclone.data.remote.restaurant.Category
import com.example.coupangeatsclone.data.remote.restaurant.CategoryResponse

interface CategoryView {
    fun onGetCategorySuccess(categoryList : ArrayList<Category>)
    fun onGetCategoryLoading()
    fun onGetCategoryFailure(code : Int, message : String)
}