package com.example.carrotmarket.src.config.src.main.btm.home.product.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal.ProductSearchDealFragment


class ProductSearchSliderAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {


        return when(position){
            0-> ProductSearchDealFragment()
//            1-> ProductSaleListCompFragment()
//            2-> ProductSaleListHideFragment()
            else -> ProductSearchDealFragment()
        }


    }

    override fun getItemCount(): Int {
        return 3
    }
}
