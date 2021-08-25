package com.example.carrotmarket.src.config.src.main.btm.products.category

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityHomeCategoryBinding
import com.example.carrotmarket.src.config.src.main.btm.products.category.models.HomeCategoryData
import com.example.carrotmarket.src.home.HomeFragment


class HomeCategoryActivity:BaseActivity<ActivityHomeCategoryBinding>(ActivityHomeCategoryBinding::inflate) {

    var homeCategoryData =ArrayList<HomeCategoryData>()

    private lateinit var homeCategoryAdapter: HomeCategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.homeCategoryRv.layoutManager= GridLayoutManager(this,3)

        homeCategoryAdapter = HomeCategoryAdapter(this,homeCategoryData)
        binding.homeCategoryRv.adapter=homeCategoryAdapter


        binding.homeCategoryImgBack.setOnClickListener {
            intent= Intent(this,HomeFragment::class.java)
            startActivity(intent)
            finish()
        }


        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon1,
                "인기매물"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon2,
                "디지털기기"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon3,
                "생활가전"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon4,
                "가구/인테리어"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon5,
                "유아동"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon6,
                "생활/가공식품"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon7,
                "유아도서"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon8,
                "스포츠/레저"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon9,
                "여성잡화"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon10,
                "여성의류"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon11,
                "남성패션/잡화"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon12,
                "게임/취미"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon13,
                "뷰티/미용"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon14,
                "반려동물용품"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon15,
                "도서/티켓/음반"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon16,
                "식물"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon17,
                "기타 중고물품"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon18,
                "삽니다"
            )
        )
    }
}