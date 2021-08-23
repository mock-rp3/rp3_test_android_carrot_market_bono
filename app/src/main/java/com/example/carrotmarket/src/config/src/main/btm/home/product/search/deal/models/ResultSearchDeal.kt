package com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal.models

data class ResultSearchDeal(
    val createdAt: String,
    val imageUrl: String,
    val price: Int,
    val productIdx: Int,
    val pulledAt: String,
    val regionNameGu: String,
    val regionNameTown: String,
    val title: String,
    val wishCount: Int
)