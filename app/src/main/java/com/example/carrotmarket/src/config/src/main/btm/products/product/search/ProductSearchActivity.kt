package com.example.carrotmarket.src.config.src.main.btm.products.product.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityHomeSearchBinding
import com.example.carrotmarket.src.config.src.main.MainActivity
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.ProductSearchDealFragment
import com.google.android.material.tabs.TabLayoutMediator

class ProductSearchActivity :
    BaseActivity<ActivityHomeSearchBinding>(ActivityHomeSearchBinding::inflate) {


    val tabLayoutTextArray = arrayOf("중고거래", "동네정보", "사람")
    var handled = false

    private lateinit var productSearchSliderAdapter: ProductSearchSliderAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productSearchSliderAdapter = ProductSearchSliderAdapter(this)
        binding.homeSearchVp2.adapter =productSearchSliderAdapter


        binding.homeSearchEtSearch.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) { //키워드 번들로 전달 >> 프레그먼트에서 데이터 조회 >> 리사이클러뷰에 데이터 넘겨주기

                val dealFragment = ProductSearchDealFragment()

                supportFragmentManager.beginTransaction().replace(R.id.home_search_vp2, dealFragment).commit()

                val bundle = Bundle()
                bundle.putString("search", binding.homeSearchEtSearch.text.toString())

                dealFragment.arguments=bundle

//            bundle.putInt("price", price.toInt())
//            bundle.putString("canProposal", canProposal)
//            bundle.putInt("categoryId", categoryId)
//            bundle.putInt("sellerId", userIdx)
//            bundle.putString("imageUrl", "test")
//            bundle.putString("contents", contents)
//
//                dealFragment.arguments = bundle
//
//
////            val transaction = supportFragmentManager.beginTransaction()
////            transaction.add(R.id.frameLayout, fragmentA)
////            transaction.commit()
//
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.home_search_vp2, dealFragment)
            transaction.commit()

//
//                ApplicationClass.sSharedPreferences =
//                    getSharedPreferences("search", MODE_PRIVATE)
//                var editor1 = ApplicationClass.sSharedPreferences.edit()
//                editor1.putString("search",
//                    binding.homeSearchEtSearch.text.toString())
//                Log.e("search", binding.homeSearchEtSearch.text.toString())
//                editor1.commit()
                binding.cancelTxt.visibility = View.GONE
                binding.invisibleView.visibility = View.GONE
                val inputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(binding.homeSearchEtSearch.windowToken,
                    0)
                handled = true
                true
            } else {
                handled
                false
            }
        }

        //초기화
//        var editor = ApplicationClass.sSharedPreferences.edit()
//        editor.remove("user_name").commit()
//        editor.remove("title").commit()

        TabLayoutMediator(binding.homeSearchTl,
            binding.homeSearchVp2) { tab, position ->
            tab.text = tabLayoutTextArray[position]
        }.attach()

        binding.homeSearchImgBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        binding.cancelTxt.setOnClickListener {
            binding.homeSearchEtSearch.setText("")
            binding.cancelTxt.visibility = View.GONE
            binding.invisibleView.visibility = View.GONE
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.homeSearchEtSearch.windowToken,
                0)
            handled = true
        }

        binding.homeSearchEtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.cancelTxt.visibility = View.VISIBLE
                binding.invisibleView.visibility = View.VISIBLE
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }
        )


//            ApplicationClass.sSharedPreferences = getSharedPreferences("title", MODE_PRIVATE)
//            var editor = ApplicationClass.sSharedPreferences.edit()
//            editor.putString("title",title)
//            editor.commit()

//            startActivity(intent)


    }

//


}