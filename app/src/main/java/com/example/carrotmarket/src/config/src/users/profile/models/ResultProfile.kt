package com.example.carrotmarket.src.config.src.users.profile.models

data class ResultProfile(
    val createdAt: String,
    val nickname: String,
    val phoneNumber: String,
    var profileImageUrl: String,
    val status: String,
    val userInfoIdx: Int
)