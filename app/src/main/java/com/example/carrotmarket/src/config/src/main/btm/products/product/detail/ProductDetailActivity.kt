package com.example.carrotmarket.src.config.src.main.btm.products.product.detail

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.databinding.ActivityProductDetailsBinding
import com.example.carrotmarket.src.config.src.main.MainActivity
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit.EditActivity
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.*
import java.text.DecimalFormat


//val images = arrayOf(
//    "https://dnvefa72aowie.cloudfront.net/origin/article/202108/51656185cfb4b9f326a0e2fea8c99331d8eb7e14683201548386687329bcc615.webp?q=95&s=1440x1440&t=inside",
//    "https://dnvefa72aowie.cloudfront.net/origin/article/202108/fa44aa18a23e036d724faedb128f1beb2ec8b4809ee967d68ffb62e6f71c0ec0.webp?q=95&s=1440x1440&t=inside"
//)

class ProductDetailActivity :
    BaseActivity<ActivityProductDetailsBinding>(ActivityProductDetailsBinding::inflate),
    ProductDetailActivityView {
    var wish: Boolean = false
    var otherArrayList = ArrayList<ResultSellerProduct>()
    var imageArrayList = ArrayList<ResultDetail>()

    private lateinit var productDetailOtherAdapter: ProductDetailOtherAdapter
    private lateinit var productDetailImageSliderAdapter: ProductDetailImageSliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // api 호출
        val productIdx = intent.getIntExtra("productIdx", 0)
        showLoadingDialog(this)
        ProductDetailService(this).tryGetProductDetail(productIdx)
        ProductDetailService(this).tryPatchViews(productIdx)

//        //스크롤 시 색상 변경
//        binding.detailAppBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener {
//            appBarLayout, verticalOffset ->
//            if (kotlin.math.abs(verticalOffset) - appBarLayout.totalScrollRange ==0){
//                binding.detailAppBar.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
//                binding.nsv.visibility=View.VISIBLE
//
//            }else{
//                binding.detailAppBar.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
//                binding.nsv.visibility=View.GONE
//            }
//        })

        // 이미지 둥글게
        binding.detailImgUserProfile.background =
            resources.getDrawable(R.drawable.image_rounding_oval)
        binding.detailImgUserProfile.clipToOutline = true


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
//            setupIndicators()

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

        val seller = response.result[0][0].userInfoIdx

        ProductDetailService(this).tryGetSellerProduct("normal",seller)

        dismissLoadingDialog()

        //ViewPager2
        productDetailImageSliderAdapter = ProductDetailImageSliderAdapter(this, response.result[1])
        binding.productDetailVp2.adapter = productDetailImageSliderAdapter

        //1 0 , 1 1
        for (i in 0 .. response.result[1].size-1) {
            Log.e("size",response.result[1].size.toString())
            imageArrayList.add(
                ResultDetail(
                    response.result[0][0].priceProposal,
                    response.result[0][0].contents,
                    response.result[0][0].mannerGrade,
                    response.result[0][0].cate,
                    response.result[0][0].nickname,
                    response.result[0][0].price,
                    response.result[1][i].imageUrl,
                    response.result[0][0].productIdx,
                    response.result[0][0].profileImageUrl,
                    response.result[0][0].pulledAt,
                    response.result[0][0].regionNameTown,
                    response.result[0][0].title,
                    response.result[0][0].viewCount,
                    response.result[0][0].userInfoIdx

                )
            )
            setupIndicators(response.result[1].size)
        }

        productDetailImageSliderAdapter.notifyDataSetChanged()

        response.result[0][0].productIdx
        binding.productDetailTxtContents.text = response.result[0][0].contents
        binding.productDetailTxtUserName.text = response.result[0][0].nickname
        binding.productWriteTxtLocal.text = response.result[0][0].regionNameTown
        binding.productDetailUserTem.text = response.result[0][0].mannerGrade.toString() + "℃"
        binding.productDetailTxtUserName2.text = response.result[0][0].nickname
        binding.productWriteTxtTitle.text = response.result[0][0].title
        binding.productDetailCate.text = response.result[0][0].cate
        binding.homeItemTime.text = response.result[0][0].pulledAt
        binding.viewCount.text = response.result[0][0].viewCount

        val decimalFormat = DecimalFormat("###,###")
        val priceDecimalFormat = decimalFormat.format(response.result[0][0].price)
        binding.detailPrice.text = "$priceDecimalFormat 원"

        Glide.with(this)
            .load(response.result[0][0].profileImageUrl)
            .into(binding.detailImgUserProfile)

        binding.productDetailCate.text =
            Html.fromHtml("<u>" + binding.productDetailCate.text + "</u>")


        if (response.result[0][0].priceProposal == "Y") {
            binding.productDetailTxtPriceProposal.text = "가격제안가능"
            binding.productDetailTxtPriceProposal.text =
                Html.fromHtml("<u>" + binding.productDetailTxtPriceProposal.text + "</u>")
            binding.productDetailTxtPriceProposal.setTextColor(Color.parseColor("#FFee8548"))
        } else {
            binding.productDetailTxtPriceProposal.text = "가격제안불가"
        }

        val productId = response.result[0][0].productIdx.toInt()
        val userInfoId = response.result[0][0].userInfoIdx.toInt()
        val requestWishDel = RequestWishDel(
            productId,
            userInfoId
        )
        val requestWish = RequestWish(
            productId,
            userInfoId
        )
        binding.productDetailTxtPriceProposal.setOnClickListener {

        }
        binding.detailImgHeart.setOnClickListener {
            if (binding.detailImgHeart.tag.toString() == "true") {

                ProductDetailService(this).tryDeleteWishProduct(requestWishDel)

            } else {
                ProductDetailService(this).tryPostWishProduct(requestWish)

            }
        }
        binding.detailImgTopMenu.setOnClickListener {
            val p = PopupMenu(applicationContext, binding.detailImgTopMenu)
            menuInflater.inflate(R.menu.menu_product_detail,
                p.menu)
//            p.setOnMenuItemClickListener(PopupListener())


            p.setOnMenuItemClickListener { MenuItem ->
                when (MenuItem?.itemId) {
                    R.id.edit -> {
                        intent = Intent(this@ProductDetailActivity, EditActivity::class.java)
                        intent.putExtra("image", response.result[1][0].imageUrl)
                        Log.e("imge",response.result[1][0].imageUrl.toString())
                        intent.putExtra("productIdx", response.result[0][0].productIdx)
                        intent.putExtra("title", binding.productDetailCate.text)
                        intent.putExtra("proposal", binding.productDetailTxtPriceProposal.text)
                        intent.putExtra("contents", binding.productDetailTxtContents.text)
                        intent.putExtra("price", binding.detailPrice.text)
                        intent.putExtra("cate", binding.productDetailCate.text)
                        startActivity(intent)
                        finish()
                        true
                    }
                    R.id.delete -> {
                        val productIdx = intent.getIntExtra("productIdx", 0)
                        ProductDetailService(this).tryDeleteProduct(productIdx)

                    }
                }
                false

            }
            p.show()
        }



    }

//    // popupMenu
//    inner class PopupListener: PopupMenu.OnMenuItemClickListener {
//
//        override fun onMenuItemClick(item: MenuItem?): Boolean {
//            when(item?.itemId) {
//                R.id.edit -> {
//
//                }
//            }
//
//
//        }
//    }

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


    override fun onGetProductDetailFailure(message: String) {
    }

    override fun onDeleteProductSuccess(response: BaseResponse) {
        intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDeleteProductFailure(message: String) {
    }

    override fun onPatchViewsSuccess(response: BaseResponse) {
    }

    override fun onPatchViewsFailure(message: String) {
    }

    override fun onGetSellerProductSuccess(response: ResponseSellerProduct) {

        for (i in 0 until response.result.size) {
            otherArrayList.add(
                ResultSellerProduct(
                    response.result[i].imageUrl,
                    response.result[i].price,
                    response.result[i].title
                )
            )
        }
        productDetailOtherAdapter.notifyDataSetChanged()

    }

    override fun onGetSellerProductFailure(message: String) {
    }

    override fun onPostWishSuccess(response: BaseResponse) {

        binding.detailImgHeart.tag="false"
        binding.detailImgHeart.setImageResource(R.drawable.heart_on_icon)

    }

    override fun onPostWishFailure(message: String) {
    }

    override fun onDeleteWishSuccess(response: BaseResponse) {
        binding.detailImgHeart.tag="true"
        binding.detailImgHeart.setImageResource(R.drawable.heart_icon)
    }

    override fun onDeleteWishFailure(message: String) {
    }

}