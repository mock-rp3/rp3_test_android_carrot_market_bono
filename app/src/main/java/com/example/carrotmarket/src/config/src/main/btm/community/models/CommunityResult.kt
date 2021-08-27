package com.example.carrotmarket.src.config.src.main.btm.community.models

data class CommunityResult(
    val commentCount: Int,
    val communityIdx: Int,
    val createdAt: String,
    val description: String,
    val name: String,
//    val reactionCount: Int,
    val regionNameTown: String
)