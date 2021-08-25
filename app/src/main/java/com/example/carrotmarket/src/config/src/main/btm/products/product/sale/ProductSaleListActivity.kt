package com.example.carrotmarket.src.config.src.main.btm.products.product.sale

import android.content.Intent
import android.os.Bundle
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityProductSaleListBinding
import com.example.carrotmarket.src.config.src.main.MainActivity
import com.google.android.material.tabs.TabLayoutMediator

class ProductSaleListActivity: BaseActivity<ActivityProductSaleListBinding>(ActivityProductSaleListBinding::inflate) {

    val tabLayoutTextArray = arrayOf("판매중", "거래완료", "숨김")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.productSaleListVp2.adapter= ProductSaleListSliderAdapter(this)

        TabLayoutMediator(binding.productSaleListTl, binding.productSaleListVp2){ tab, position ->
            tab.text =tabLayoutTextArray[position]
        }.attach()


        binding.productSaleListImgBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}