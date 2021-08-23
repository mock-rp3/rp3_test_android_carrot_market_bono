package com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentSearchDealBinding
import com.example.carrotmarket.src.config.src.main.btm.home.HomeCategoryAdapter
import com.example.carrotmarket.src.config.src.main.btm.home.models.HomeCategoryData
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal.models.ResponseSearchDeal

class ProductSearchDealFragment:BaseFragment<FragmentSearchDealBinding>(FragmentSearchDealBinding::bind, R.layout.fragment_search_deal),
ProductSearchDealFragmentView{
    var homeCategoryData =ArrayList<HomeCategoryData>()

    private lateinit var homeCategoryAdapter: HomeCategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.searchRv.layoutManager= GridLayoutManager(requireContext(),4)

        homeCategoryAdapter = HomeCategoryAdapter(requireContext(),homeCategoryData)
        binding.searchRv.adapter=homeCategoryAdapter

        ApplicationClass.sSharedPreferences =
            requireActivity().getSharedPreferences("title", AppCompatActivity.MODE_PRIVATE)

        val title = ApplicationClass.sSharedPreferences.getString("title", null)
        Log.e("title2",title.toString())

        binding.searchTxtCate.setOnClickListener{
            Log.e("title3",title.toString())
            ProductSearchService(this).tryGetDealSearch(title!!)
        }

//        val title =requireActivity().intent.getStringExtra("title")



        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon2,
                "디지털기기"
            )
        )

        homeCategoryData.add(
            HomeCategoryData(
                R.drawable.cate_icon1,
                "인기매물"
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





    }

    override fun onGetDealSearchSuccess(response: ResponseSearchDeal) {
    }

    override fun onGetDealSearchFailure(message: String) {
    }

}