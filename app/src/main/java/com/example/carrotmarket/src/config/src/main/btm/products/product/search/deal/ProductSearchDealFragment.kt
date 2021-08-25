package com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentSearchDealBinding
import com.example.carrotmarket.src.config.src.main.btm.products.category.HomeCategoryAdapter
import com.example.carrotmarket.src.config.src.main.btm.products.category.models.HomeCategoryData
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.ProductDetailOtherAdapter
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.ResultSellerProduct
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResponseSearchDeal
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResponseSug
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResultSearchDeal

class ProductSearchDealFragment:
    BaseFragment<FragmentSearchDealBinding>(FragmentSearchDealBinding::bind,
        R.layout.fragment_search_deal),
    ProductSearchDealFragmentView {
    var homeCategoryData = ArrayList<HomeCategoryData>()
    var responseArrayList = ArrayList<ResultSearchDeal>()
    var otherArrayList = ArrayList<ResultSellerProduct>()

    private lateinit var homeCategoryAdapter: HomeCategoryAdapter
    private lateinit var dealAdapter: DealAdapter
    private lateinit var productDetailOtherAdapter: ProductDetailOtherAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingDialog(requireContext())
        ProductSearchService(this).tryGetSuggest()

        ApplicationClass.sSharedPreferences = requireActivity().getSharedPreferences("nickName", AppCompatActivity.MODE_PRIVATE)

        binding.userTxtName.text = ApplicationClass.sSharedPreferences.getString("nickName", null)
        Log.e("nick",binding.userTxtName.text.toString())

        binding.userTxtName.text=binding.userTxtName.text.toString()+"님, 이건 어때요?"
//        Log.e("nick2",binding.userTxtName.text.toString())

        productDetailOtherAdapter = ProductDetailOtherAdapter(requireActivity(), otherArrayList)
        binding.sugRv.adapter = productDetailOtherAdapter

        binding.sugRv.layoutManager = GridLayoutManager(requireActivity(), 2)

        dealAdapter = DealAdapter(requireActivity(), responseArrayList)
        binding.searchDealRv.adapter = dealAdapter

        binding.searchRv.layoutManager = GridLayoutManager(requireContext(), 4)

        homeCategoryAdapter = HomeCategoryAdapter(requireContext(), homeCategoryData)
        binding.searchRv.adapter = homeCategoryAdapter

//        ApplicationClass.sSharedPreferences =
//            requireActivity().getSharedPreferences("search", AppCompatActivity.MODE_PRIVATE)
//
//        val title = ApplicationClass.sSharedPreferences.getString("search", null)



        val search = arguments?.getString("search")

        binding.searchTxtCate.setOnClickListener {
//            Log.e("title3", search.toString())
            showLoadingDialog(requireActivity())
            ProductSearchService(this).tryGetDealSearch(search!!)
            binding.searchDealRv.visibility = View.VISIBLE
            binding.searchDealLl.visibility = View.GONE

//            var editor = ApplicationClass.sSharedPreferences.edit()
//            editor.remove("title").commit()
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

        dismissLoadingDialog()
        for (i in 0 until response.result.size) {
            responseArrayList.add(0,
                ResultSearchDeal(
                    response.result[i].imageUrl,
                    response.result[i].price,
                    response.result[i].productIdx,
                    response.result[i].pulledAt,
                    response.result[i].regionNameTown,
                    response.result[i].title,
                    response.result[i].wishCount
                )
            )

        }
        dealAdapter.notifyDataSetChanged()
    }

    override fun onGetDealSearchFailure(message: String) {
    }

    override fun onGetSuggestSuccess(response: ResponseSug) {
        dismissLoadingDialog()

        for (i in 0 until  response.result.size) {
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

    override fun onGetSuggestFailure(message: String) {

    }

}