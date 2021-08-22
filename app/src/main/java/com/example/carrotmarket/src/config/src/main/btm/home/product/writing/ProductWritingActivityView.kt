package com.example.carrotmarket.src.config.src.main.btm.home.product.writing

import com.example.carrotmarket.src.config.src.main.btm.home.product.writing.models.ResponseWriting

interface ProductWritingActivityView {


    fun onPostProductWritingSuccess(response: ResponseWriting)
    fun onPostProductWritingFailure(message: String)
}