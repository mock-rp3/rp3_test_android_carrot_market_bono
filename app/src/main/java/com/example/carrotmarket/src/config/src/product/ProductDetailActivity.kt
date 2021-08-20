package com.example.carrotmarket.src.config.src.product

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityProductDetailsBinding
import com.example.carrotmarket.src.config.src.main.MainActivity


data class Other(
    val productDetailOtherImage: Int,
    val productDetailOtherName: String,
    val productDetailOtherPrice: String,
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


        //top_icon
        binding.detailImgTopBack.setOnClickListener {
            intent =Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        //밑줄 넣기
        binding.productDetailTxtUserTem.text = Html.fromHtml("<u>"+binding.productDetailTxtUserTem.text+"</u>")
        binding.productDetailCate.text = Html.fromHtml("<u>"+binding.productDetailCate.text+"</u>")


        //Recyclerview
        productDetailOtherAdapter= ProductDetailOtherAdapter(this, otherArrayList)
        binding.productDetailRvOthers.adapter=productDetailOtherAdapter

        binding.productDetailRvOthers.layoutManager=GridLayoutManager(this,2)




        //ViewPager2
        productDetailImageSliderAdapter= ProductDetailImageSliderAdapter(this,images)
        binding.productDetailVp2.adapter=productDetailImageSliderAdapter

        binding.productDetailVp2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        setupIndicators(images.size)




        //더미데이터
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

    private fun setupIndicators(count: Int) {
        val indicators: Array<ImageView?> = arrayOfNulls<ImageView>(count)
        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(14, 8, 14, 8)
        for (i in indicators.indices) {
            indicators[i] = ImageView(this)
            indicators[i]!!.setImageDrawable(ContextCompat.getDrawable(this,
                R.drawable.detail_vp2_indicator_inactive))
            indicators[i]!!.layoutParams = params
            binding.detailLlIndicator.addView(indicators[i])
        }
        setCurrentIndicator(0)
    }

    private fun setCurrentIndicator(position: Int) {
        val childCount: Int =  binding.detailLlIndicator.childCount
        for (i in 0 until childCount) {
            val imageView: ImageView =  binding.detailLlIndicator.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                    this,
                    R.drawable.detail_vp2_indicator_active
                ))
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                    this,
                    R.drawable.detail_vp2_indicator_inactive
                ))
            }
        }
    }

}