package com.example.carrotmarket.src.config.src.main.btm.products.category.select.models

import com.example.carrotmarket.config.BaseResponse

data class CategorySelectResponse(

    val result: List<CategorySelectResult>
): BaseResponse()