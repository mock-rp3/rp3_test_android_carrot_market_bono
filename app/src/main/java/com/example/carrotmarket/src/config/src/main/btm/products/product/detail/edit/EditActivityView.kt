package com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit

import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit.models.EditResponse

interface EditActivityView {

    fun onPatchProductDetailSuccess(response: EditResponse)
    fun onPatchProductDetailFailure(message: String)
}