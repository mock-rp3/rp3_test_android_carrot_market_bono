package com.example.carrotmarket.src.config.src.main.btm.home.product.search.user

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentSearchUserBinding
import com.example.carrotmarket.src.config.src.main.btm.home.models.ResultHome
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal.ProductSearchService
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.user.models.UserResponse
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.user.models.UserResult

class ProductSearchUserFragment :
    BaseFragment<FragmentSearchUserBinding>(FragmentSearchUserBinding::bind,
        R.layout.fragment_search_user),
    ProductSearchUserFragmentView {
    var userResponse = ArrayList<UserResult>()

    lateinit var userAdapter: UserAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        userAdapter = UserAdapter(requireContext(), userResponse)
        binding.searchUserRv.adapter = userAdapter


//        ApplicationClass.sSharedPreferences =
//            requireActivity().getSharedPreferences("search", AppCompatActivity.MODE_PRIVATE)
//
//        val userName = ApplicationClass.sSharedPreferences.getString("search", null)
//        Log.e("search", userName.toString())

//        val search = arguments?.getString("search")
//        Log.e("title2", search.toString())

//        if (userName==null){
//
//        }else{
        binding.test.setOnClickListener {
            showLoadingDialog(requireActivity())
//            ProductSearchUserService(this).tryGetUserSearch(search!!)
            binding.searchUserLl.visibility = View.GONE
            binding.searchUserRv.visibility = View.VISIBLE
//                userAdapter.notifyDataSetChanged()

//                var editor = ApplicationClass.sSharedPreferences.edit()
//                editor.remove("user_name").commit()
        }
//        }


//
//
//


    }

    override fun onGetUserSearchSuccess(response: UserResponse) {
        dismissLoadingDialog()

        Log.e("response.result.size", response.result.size.toString())

        Log.e("userResponse", userAdapter.userDataList.size.toString())
//        if (response.result[0].equals(userResponse[0])){
//
//        }else {
//
//        if(response.result[0] == userResponse[0]){
//
//        }else{
//        if(userAdapter.userDataList[0] ==userResponse[0]){

//        }else{
        for (i in 0 until response.result.size) {
            userResponse.add(0,
                UserResult(
                    response.result[i].nickname,
                    response.result[i].profileImageUrl
                )
            )

        }
        userAdapter.notifyDataSetChanged()

    }

    override fun onGetUserSearchFailure(message: String) {
    }
}