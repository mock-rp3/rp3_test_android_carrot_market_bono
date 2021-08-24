package com.example.carrotmarket.src.config.src.main.btm.home.product.search

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal.ProductSearchDealFragment
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.local.ProductSearchLocalFragment
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.user.ProductSearchUserFragment


class ProductSearchSliderAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {

            return when (position) {
                0 -> ProductSearchDealFragment()
                1 -> ProductSearchLocalFragment()
                2 -> ProductSearchUserFragment()
                else -> ProductSearchDealFragment()
            }


    }

    override fun getItemCount(): Int {
        return 3
    }
}
