package com.example.carrotmarket.src.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentHomeBinding
import com.example.carrotmarket.src.config.src.main.btm.products.category.HomeCategoryActivity
import com.example.carrotmarket.src.config.src.main.btm.products.HomeFragmentView
import com.example.carrotmarket.src.config.src.main.btm.products.ProductsService
import com.example.carrotmarket.src.config.src.main.btm.products.models.ResponseHome
import com.example.carrotmarket.src.config.src.main.btm.products.models.ResultHome
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.ProductSearchActivity

class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
    HomeFragmentView {

    var responseHome = ArrayList<ResultHome>()
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeAdapter = HomeAdapter(requireActivity(), responseHome)
        binding.homeRv.adapter = homeAdapter
        showLoadingDialog(requireActivity())
        ProductsService(this).tryGetHome()



//        val addProductIdx = arguments?.getInt("productIdx")
//        Log.e("id",addProductIdx.toString())
//        val addTitle = arguments?.getString("title")
//        val addPrice = arguments?.getInt("price")
//        val addCanProposal = arguments?.getString("canProposal")
//        val addCategoryId = arguments?.getInt("categoryId")
//        val addSellerId = arguments?.getInt("sellerId")
//        val addImageUrl = arguments?.getString("imageUrl")
//        val addContents = arguments?.getString("contents")



        //1 . Activity () -> X
        //2. requireActivity() -> O
        //3. requireContext() -> O
        val dividerItemDecoration = DividerItemDecoration(
            context, LinearLayoutManager(requireActivity()).orientation)
        binding.homeRv.addItemDecoration(dividerItemDecoration)

        binding.homeBtnLocationAuth.setOnClickListener {
            binding.homeCvInfo.visibility = View.GONE
        }

        binding.homeSrl.setOnRefreshListener {
            binding.homeSrl.isRefreshing = false
        }

        binding.homeImgTopMenu.setOnClickListener {
            var intent = Intent(context, HomeCategoryActivity::class.java)
            startActivity(intent)
        }
        binding.homeImgTopSearch.setOnClickListener {
            var intent = Intent(context, ProductSearchActivity::class.java)
            startActivity(intent)
        }

//
//        productArrayList.add(
//            Product(
//                "https://lh3.googleusercontent.com/proxy/xEkPEcc_tTpZBC7leROlQ_I8iMeSnSOJMpFNp2oGY3lDfaK_6S-PgskZAAvnr-mgb0z2_P9ldwYkkJg1C-XFygzZRaSm1CryFcX8WsGwIUA6Lg_tvg",
//                "캉골 반팔티",
//                "천호제3동",
//                "1분 전",
//                15000
//            )
//        )


    }

    override fun onGetProductSuccess(response: ResponseHome) {
        dismissLoadingDialog()
        //끌올 순 정렬
        for (i in 0 until response.result.size) {
            responseHome.add(
                ResultHome(
                    response.result[i].productIdx,
                    response.result[i].imageUrl,
                    response.result[i].title,
                    response.result[i].regionNameTown,
                    response.result[i].pulledAt,
                    response.result[i].price,
                    response.result[i].wishCount
                )
            )
        }
        homeAdapter.notifyDataSetChanged()



//
//        responseHome.add(
//            ResultHome(
//                addProductIdx!!,
//                addImageUrl!!,
//                addTitle!!,
//                "test",
//                "test",
//                addPrice!!
//            )
//        )


    }



    override fun onGetProductFailure(message: String) {
    }


}