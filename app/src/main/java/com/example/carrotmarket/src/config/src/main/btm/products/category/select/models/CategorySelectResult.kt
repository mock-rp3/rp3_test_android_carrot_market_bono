package com.example.carrotmarket.src.config.src.main.btm.products.category.select.models

data class CategorySelectResult(
//    val createdAt: String,
    val productIdx: Int,
    val imageUrl: String,
    val title: String,

//    val regionNameGu: String,
    val regionNameTown: String,
    val pulledAt: String,

    val price: Int,

    val wishCount: Int
)