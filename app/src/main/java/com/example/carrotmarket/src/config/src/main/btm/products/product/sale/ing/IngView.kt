package com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing

import com.example.carrotmarket.src.config.src.main.btm.products.models.ResponseHome
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResponse

interface IngView {

    fun onGetIngSuccess(response: IngResponse)
    fun onGetIngFailure(message: String)
}