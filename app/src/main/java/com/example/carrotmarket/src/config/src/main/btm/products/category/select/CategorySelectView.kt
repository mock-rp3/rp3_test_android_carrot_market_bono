package com.example.carrotmarket.src.config.src.main.btm.products.category.select

import com.example.carrotmarket.src.config.src.main.btm.products.category.select.models.CategorySelectResponse

interface CategorySelectView {

    fun onGetCategorySuccess(response: CategorySelectResponse)
    fun onGetCategoryFailure(message: String)
}