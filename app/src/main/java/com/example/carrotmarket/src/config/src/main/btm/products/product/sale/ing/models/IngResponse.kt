package com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models

data class IngResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<IngResult>
)