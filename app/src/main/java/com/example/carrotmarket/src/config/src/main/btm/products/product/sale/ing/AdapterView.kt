package com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing

import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResponse

interface AdapterView {

    fun onPatchStatusSuccess(response: BaseResponse)
    fun onPatchStatusFailure(message: String)
}