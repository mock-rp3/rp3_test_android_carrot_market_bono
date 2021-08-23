package com.example.carrotmarket.src.config.src.main.btm.home.product.detail

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityProductDetailsBinding
import com.example.carrotmarket.src.config.src.main.MainActivity
import com.example.carrotmarket.src.config.src.main.btm.home.product.detail.models.ResponseDetail
import com.google.gson.annotations.SerializedName


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
    BaseActivity<ActivityProductDetailsBinding>(ActivityProductDetailsBinding::inflate),
    ProductDetailActivityView {

    var otherArrayList = ArrayList<Other>()

    private lateinit var productDetailImageSliderAdapter: ProductDetailImageSliderAdapter
    private lateinit var productDetailOtherAdapter: ProductDetailOtherAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        // 이미지 둥글게
        binding.detailImgUserProfile.background =
            resources.getDrawable(R.drawable.image_rounding_oval)
        binding.detailImgUserProfile.clipToOutline = true



        showLoadingDialog(this)
        // api 호출
        val productIdx = intent.getIntExtra("productIdx",0)
        ProductDetailService(this).tryGetProductDetail(productIdx)


        //top_icon
        binding.detailImgTopBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        //밑줄 넣기
        binding.productDetailTxtUserTem.text =
            Html.fromHtml("<u>" + binding.productDetailTxtUserTem.text + "</u>")



        //Recyclerview
        productDetailOtherAdapter = ProductDetailOtherAdapter(this, otherArrayList)
        binding.productDetailRvOthers.adapter = productDetailOtherAdapter

        binding.productDetailRvOthers.layoutManager = GridLayoutManager(this, 2)


        //ViewPager2
        productDetailImageSliderAdapter = ProductDetailImageSliderAdapter(this, images)
        binding.productDetailVp2.adapter = productDetailImageSliderAdapter

        binding.productDetailVp2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

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
        val childCount: Int = binding.detailLlIndicator.childCount
        for (i in 0 until childCount) {
            val imageView: ImageView = binding.detailLlIndicator.getChildAt(i) as ImageView
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

    override fun onGetProductDetailSuccess(response: ResponseDetail) {
        dismissLoadingDialog()
        binding.productDetailTxtContents.text = response.result[0][0].contents
        binding.productDetailTxtUserName.text = response.result[0][0].nickname
        binding.productWriteTxtLocal.text = response.result[0][0].regionNameTown
        binding.productDetailUserTem.text = response.result[0][0].mannerGrade.toString() + "℃"
        binding.productDetailTxtUserName2.text = response.result[0][0].nickname
        binding.productWriteTxtTitle.text = response.result[0][0].title
        binding.productDetailCate.text = response.result[0][0].cate
        binding.productDetailTxtPriceProposal.text = response.result[0][0].priceProposal
        binding.homeItemTime.text = response.result[0][0].pulledAt

        Glide.with(this)
            .load(response.result[0][0].profileImageUrl)
            .into(binding.detailImgUserProfile)

        binding.productDetailCate.text =
            Html.fromHtml("<u>" + binding.productDetailCate.text + "</u>")


        if (response.result[0][0].priceProposal == "Y") {
            binding.productDetailTxtPriceProposal.text = "가격제안가능"
            binding.productDetailTxtPriceProposal.text=Html.fromHtml("<u>" + binding.productDetailTxtPriceProposal.text + "</u>")
            binding.productDetailTxtPriceProposal.setTextColor(Color.parseColor("#FFee8548"))
        }else {
            binding.productDetailTxtPriceProposal.text = "가격제안불가"
        }

//        var a = Glide.with(this)
//            .load(response.result[0][0].imageUrl)
//            .into(binding.productDetailVp2)
//
//
//        //ViewPager2
//        productDetailImageSliderAdapter = ProductDetailImageSliderAdapter(this, response.result[0][1].imageUrl)
//        binding.productDetailVp2.adapter = productDetailImageSliderAdapter
//
//        binding.productDetailVp2.registerOnPageChangeCallback(object :
//            ViewPager2.OnPageChangeCallback() {
//
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int,
//            ) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
//
//            }
//
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                setCurrentIndicator(position)
//            }
//        })
//        setupIndicators(response.result[0][0].imageUrl)


    }

    override fun onGetProductDetailFailure(message: String) {
    }

}