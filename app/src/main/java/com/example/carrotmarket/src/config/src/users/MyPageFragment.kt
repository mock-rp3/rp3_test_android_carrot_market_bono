package com.example.carrotmarket.src.config.src.users

import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentMyPageBinding
import com.example.carrotmarket.src.config.src.users.models.MyPageResponse
import com.example.carrotmarket.src.config.src.users.models.ResultMyPage
import com.example.carrotmarket.src.users.SignUpService

class MyPageFragment :
    BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page),
    MyPageFragmentView {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MyPageService(this).tryGetMyPage(30)
    }

    override fun onGetMyPageSuccess(response: MyPageResponse) {

        var s= response.result.userInfoIdx.toInt()
        MyPageService(this).tryGetMyPage(response.result.userInfoIdx.toInt())

        binding.myPageUserName.text =
            response.result.nickname.toString()

//        binding.myPageUserName.text =
//            response.result.nickname.toString()


        Glide.with(this)
            .load(response.result.profileImageUrl)
            .into(binding.myPageImgUserProfile)

    }

    override fun onGetMyPageFailure(message: String) {

    }


}