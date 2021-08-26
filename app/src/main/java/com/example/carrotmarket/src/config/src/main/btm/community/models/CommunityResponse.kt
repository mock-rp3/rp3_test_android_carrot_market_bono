package com.example.carrotmarket.src.config.src.main.btm.community.models

data class CommunityResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<CommunityResult>
)