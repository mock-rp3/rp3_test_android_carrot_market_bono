package com.example.carrotmarket.src.config.src.users

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.carrotmarket.config.ApplicationClass.Companion.sSharedPreferences
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentMyPageBinding
import com.example.carrotmarket.src.config.src.users.models.MyPageResponse


class MyPageFragment :
    BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page),
    MyPageFragmentView {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //이미지 둥글게
        binding.myPageImgUserProfile.background = resources.getDrawable(R.drawable.image_rounding_oval)
        binding.myPageImgUserProfile.clipToOutline = true

        // jwt 가져오기
        sSharedPreferences =
            requireActivity().getSharedPreferences(X_ACCESS_TOKEN, AppCompatActivity.MODE_PRIVATE)
        val jwt = sSharedPreferences.getString(X_ACCESS_TOKEN, null)!!
        Log.e("jwt10", jwt.toString())

        // userIdx 가져오기
        sSharedPreferences =
            requireActivity().getSharedPreferences("userIdx", AppCompatActivity.MODE_PRIVATE)

        val userIdx = sSharedPreferences.getInt("userIdx", 0)
        Log.e("userIdx2", userIdx.toString())

        showLoadingDialog(requireActivity())
        // 값 넣어주기
        MyPageService(this).tryGetMyPage(jwt, userIdx)


        binding.detailImgTopSetting.setOnClickListener {
            var intent = Intent(context, UsersSettingActivity::class.java)
            startActivity(intent)
//            activity?.finish()
        }



    }

    override fun onGetMyPageSuccess(response: MyPageResponse) {
        dismissLoadingDialog()
//        var editor = sSharedPreferences.edit()
//
//        sSharedPreferences = requireActivity().getSharedPreferences("userIdx", Context.MODE_PRIVATE)
//        editor.putInt("userIdx", response.result.userInfoIdx)
//        editor.commit()

        binding.myPageUserName.text =
            response.result.nickname.toString()

        Glide.with(this)
            .load(response.result.profileImageUrl)
            .into(binding.myPageImgUserProfile)

    }

    override fun onGetMyPageFailure(message: String) {

    }


}