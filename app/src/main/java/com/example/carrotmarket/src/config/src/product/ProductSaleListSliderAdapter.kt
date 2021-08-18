package com.example.carrotmarket.src.config.src.product

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.carrotmarket.databinding.ProductDetailItemSliderBinding

class ProductSaleListSliderAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> ProductSaleListIngFragment()
            1-> ProductSaleListCompFragment()
            2-> ProductSaleListHideFragment()
            else -> ProductSaleListIngFragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}
