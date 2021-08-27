package com.example.carrotmarket.src.config.src.main.btm.community.write.models

import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.models.ResultWriting



data class CWritingResponse(

    val result: CWritingResult,
) : BaseResponse()