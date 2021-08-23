package com.example.carrotmarket.src.home

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentHomeBinding
import com.example.carrotmarket.src.config.src.main.btm.home.HomeCategoryActivity
import com.example.carrotmarket.src.config.src.main.btm.home.HomeFragmentView
import com.example.carrotmarket.src.config.src.main.btm.home.HomeService
import com.example.carrotmarket.src.config.src.main.btm.home.models.ResponseHome
import com.example.carrotmarket.src.config.src.main.btm.home.models.ResultHome
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.ProductSearchActivity

//
//data class Product(
//    val item_img: String,
//    val item_name: String,
//    val item_location: String,
//    val item_time: String,
//    val item_price: Int,
//)


class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
    HomeFragmentView {
    var responseHome = ArrayList<ResultHome>()
//    var a =List<ResultHome>()
//    var ResponseHome<ResultHome>

//    var
//    var productArrayList = ArrayList<Product>()
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeAdapter = HomeAdapter(requireActivity(), responseHome)
        binding.homeRv.adapter = homeAdapter

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
        showLoadingDialog(requireContext())
        HomeService(this).tryGetHome()

    }

    override fun onGetProductSuccess(response: ResponseHome) {
        dismissLoadingDialog()
        for (i in 0 until  response.result.size) {
            responseHome.add(
                ResultHome(
                    response.result[i].productIdx,
                    response.result[i].imageUrl,
                    response.result[i].title,
                    response.result[i].regionNameTown,
                    response.result[i].pulledAt,
                    response.result[i].price
                )
            )
        }
        homeAdapter.notifyDataSetChanged()


    }



    override fun onGetProductFailure(message: String) {
    }


}