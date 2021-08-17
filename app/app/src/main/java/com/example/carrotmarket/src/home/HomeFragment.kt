package com.example.carrotmarket.src.home

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
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
    private var isFabOpen = false

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

        binding.fabMain.setOnClickListener {
            toggleFab()
        }

        binding.homeFab1.setOnClickListener {

        }

        // 플로팅 버튼 클릭 이벤트 - 수정
        binding.homeFab2.setOnClickListener {
        }
        binding.homeViBack.setOnClickListener {
            binding.homeViBack.visibility = View.GONE
            binding.homeFab1.hide()
            binding.homeFab2.hide()
            ObjectAnimator.ofFloat(binding.fabMain, View.ROTATION, 135f, 0f).apply { start() }
            isFabOpen = false
            binding.homeTxtFab1Info.visibility = View.GONE
            binding.homeTxtFab2Info.visibility = View.GONE
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

    private fun toggleFab() {
        Log.e("메인 플로팅 버튼 클릭", "dd")

        // 플로팅 액션 버튼 닫기 - 열려있는 플로팅 버튼 집어넣는 애니메이션 세팅
        if (isFabOpen) {
            //TranslationY 는 상하방향, TranslationX는 좌우 방향, View.ROTATION은 회전을 구현 할 수 있다.
//            ObjectAnimator.ofFloat(binding.fabCamera, "translationY", 0f).apply { start() }
//            ObjectAnimator.ofFloat(binding.fabEdit, "translationY", 0f).apply { start() }
            binding.homeViBack.visibility = View.GONE
//            binding.fabEdit.visibility = View.INVISIBLE
//            binding.fabCamera.visibility = View.INVISIBLE
            binding.homeFab1.hide()
            binding.homeFab2.hide()
            binding.homeTxtFab1Info.visibility = View.GONE
            binding.homeTxtFab2Info.visibility = View.GONE
            ObjectAnimator.ofFloat(binding.fabMain, View.ROTATION, 135f, 0f).apply { start() }
//            binding.fabMain.setImageResource(R.drawable.bottom_floating_btn_icon)

            // 플로팅 액션 버튼 열기 - 닫혀있는 플로팅 버튼 꺼내는 애니메이션 세팅
        } else {

            binding.homeViBack.bringToFront() // 최상단으로 보내주기
            binding.homeTxtFab2Info.bringToFront()
            binding.homeTxtFab1Info.bringToFront()
//            ObjectAnimator.ofFloat(binding.fabCamera, "translationY", -340f).apply { start() }
//            ObjectAnimator.ofFloat(binding.fabEdit, "translationY", -180f).apply { start() }
            binding.homeViBack.visibility = View.VISIBLE
            binding.homeTxtFab1Info.visibility = View.VISIBLE
            binding.homeTxtFab2Info.visibility = View.VISIBLE
//            binding.fabEdit.visibility = View.VISIBLE
//            binding.fabCamera.visibility = View.VISIBLE

            binding.homeFab1.show()
            binding.homeFab2.show()

            ObjectAnimator.ofFloat(binding.fabMain, View.ROTATION, 0f, 135f).apply { start() }

//            binding.fabMain.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));

        }

        isFabOpen = !isFabOpen

    }

}