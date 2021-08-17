package com.example.carrotmarket.src.home

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentHomeBinding


data class Product(
    val item_img: Int,
    val item_name: String,
    val item_location: String,
    val item_time: String,
    val item_price: String,
)


class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {

    var productArrayList = ArrayList<Product>()
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeAdapter = HomeAdapter(requireActivity(), productArrayList)
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

        productArrayList.add(
            Product(
                R.drawable.item_image,
                "캉골 반팔티",
                "천호제3동",
                "1분 전",
                "15,000원"
            )
        )
        productArrayList.add(
            Product(
                R.drawable.item_image,
                "캉골 반팔티",
                "천호제3동",
                "1분 전",
                "15,000원"
            )
        )
        productArrayList.add(
            Product(
                R.drawable.item_image,
                "캉골 반팔티",
                "천호제3동",
                "1분 전",
                "15,000원"
            )
        )
        productArrayList.add(
            Product(
                R.drawable.item_image,
                "캉골 반팔티",
                "천호제3동",
                "1분 전",
                "15,000원"
            )
        )
        productArrayList.add(
            Product(
                R.drawable.item_image,
                "캉골 반팔티",
                "천호제3동",
                "1분 전",
                "15,000원"
            )
        )
        productArrayList.add(
            Product(
                R.drawable.item_image,
                "캉골 반팔티",
                "천호제3동",
                "1분 전",
                "15,000원"
            )
        )

    }



}