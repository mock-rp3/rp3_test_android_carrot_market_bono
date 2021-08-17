package com.example.carrotmarket.src.config.src.product

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityProductDetailsBinding

data class Other(
    val productDetailOtherImage: Int,
    val productDetailOtherName: String,
    val productDetailOtherPrice: String
)

val images = arrayOf(
    "https://dnvefa72aowie.cloudfront.net/origin/article/202108/51656185cfb4b9f326a0e2fea8c99331d8eb7e14683201548386687329bcc615.webp?q=95&s=1440x1440&t=inside",
"https://dnvefa72aowie.cloudfront.net/origin/article/202108/fa44aa18a23e036d724faedb128f1beb2ec8b4809ee967d68ffb62e6f71c0ec0.webp?q=95&s=1440x1440&t=inside"
)

class ProductDetailActivity :
    BaseActivity<ActivityProductDetailsBinding>(ActivityProductDetailsBinding::inflate) {

    var otherArrayList= ArrayList<Other>()

    private lateinit var productDetailImageSliderAdapter: ProductDetailImageSliderAdapter
    private lateinit var productDetailOtherAdapter: ProductDetailOtherAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productDetailOtherAdapter= ProductDetailOtherAdapter(this, otherArrayList)
        binding.productDetailRvOthers.adapter=productDetailOtherAdapter

        productDetailImageSliderAdapter= ProductDetailImageSliderAdapter(this,images)
        binding.productDetailVp2.adapter=productDetailImageSliderAdapter

        binding.productDetailRvOthers.layoutManager=GridLayoutManager(this,2)

        binding.productDetailVp2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

            }
        })

        otherArrayList.add(
            Other(
                R.drawable.item_image,
                "스타벅스 랜턴",
                "15,000원"
            )
        )

        otherArrayList.add(
            Other(
                R.drawable.item_image,
                "스타벅스 랜턴",
                "15,000원"
            )
        )

    }

}