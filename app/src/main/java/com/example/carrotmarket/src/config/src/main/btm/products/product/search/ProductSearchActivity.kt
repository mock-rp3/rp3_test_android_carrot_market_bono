package com.example.carrotmarket.src.config.src.main.btm.products.product.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityHomeSearchBinding
import com.example.carrotmarket.src.config.src.main.MainActivity
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.ProductSearchDealFragment
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.local.ProductSearchLocalFragment
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.user.ProductSearchUserFragment
import com.google.android.material.tabs.TabLayout

class ProductSearchActivity :
    BaseActivity<ActivityHomeSearchBinding>(ActivityHomeSearchBinding::inflate) {


//    val tabLayoutTextArray = arrayOf("중고거래", "동네정보", "사람")
    var handled = false



    lateinit var tab1:ProductSearchDealFragment
    lateinit var tab2:ProductSearchLocalFragment
    lateinit var tab3:ProductSearchUserFragment

//    private lateinit var productSearchSliderAdapter: ProductSearchSliderAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        productSearchSliderAdapter = ProductSearchSliderAdapter(this)
//        binding.homeSearchVp2.adapter = productSearchSliderAdapter


        tab1=ProductSearchDealFragment()
        tab2= ProductSearchLocalFragment()
        tab3= ProductSearchUserFragment()

        supportFragmentManager.beginTransaction().add(R.id.home_search_vp2, tab1).commit()

        binding.homeSearchTl.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0->{
                        replaceView(tab1)

                    }
                    1->{
                        replaceView(tab2)

                    }
                    2->{
                        replaceView(tab3)
                        binding.homeSearchEtSearch.setOnEditorActionListener { v, actionId, event ->
                            if (actionId == EditorInfo.IME_ACTION_DONE) { //키워드 번들로 전달 >> 프레그먼트에서 데이터 조회 >> 리사이클러뷰에 데이터 넘겨주기

                                val userFragment = ProductSearchUserFragment()

                                val bundle2 = Bundle()
                                bundle2.putString("search2", binding.homeSearchEtSearch.text.toString())
                                Log.e("dd",bundle2.toString())

                                userFragment.arguments =bundle2

                                val transaction2 = supportFragmentManager.beginTransaction()
                                transaction2.add(R.id.home_search_vp2, userFragment)
                                transaction2.commit()


                                binding.cancelTxt.visibility = View.GONE
                                binding.invisibleView.visibility = View.GONE

                                //키보드 내리기
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
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })


        binding.homeSearchEtSearch.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) { //키워드 번들로 전달 >> 프레그먼트에서 데이터 조회 >> 리사이클러뷰에 데이터 넘겨주기

                val dealFragment = ProductSearchDealFragment()

                val bundle = Bundle()
                bundle.putString("search", binding.homeSearchEtSearch.text.toString())

                dealFragment.arguments =bundle

                Log.e("search",bundle.toString())
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.home_search_vp2, dealFragment)
                transaction.commit()

                binding.cancelTxt.visibility = View.GONE
                binding.invisibleView.visibility = View.GONE

                //키보드 내리기
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


//        binding.homeSearchEtSearch.setOnEditorActionListener { v, actionId, event ->
//            if (actionId == EditorInfo.IME_ACTION_DONE) { //키워드 번들로 전달 >> 프레그먼트에서 데이터 조회 >> 리사이클러뷰에 데이터 넘겨주기
//
//                val userFragment = ProductSearchUserFragment()
//
//                val bundle2 = Bundle()
//                bundle2.putString("search2", binding.homeSearchEtSearch.text.toString())
//                Log.e("dd",bundle2.toString())
//
//                userFragment.arguments =bundle2
//
//                val transaction2 = supportFragmentManager.beginTransaction()
//                transaction2.add(R.id.home_search_vp2, userFragment)
//                transaction2.commit()
//
//
//                binding.cancelTxt.visibility = View.GONE
//                binding.invisibleView.visibility = View.GONE
//
//                //키보드 내리기
//                val inputMethodManager =
//                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                inputMethodManager.hideSoftInputFromWindow(binding.homeSearchEtSearch.windowToken,
//                    0)
//
//                handled = true
//                true
//            } else {
//                handled
//                false
//            }
//        }

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


                //                ApplicationClass.sSharedPreferences =
//                    getSharedPreferences("search", MODE_PRIVATE)
//                var editor1 = ApplicationClass.sSharedPreferences.edit()
//                editor1.putString("search",
//                    binding.homeSearchEtSearch.text.toString())
//                Log.e("search", binding.homeSearchEtSearch.text.toString())
//                editor1.commit()
                //            bundle.putInt("price", price.toInt())
//            bundle.putString("canProposal", canProposal)
//            bundle.putInt("categoryId", categoryId)
//            bundle.putInt("sellerId", userIdx)
//            bundle.putString("imageUrl", "test")
//            bundle.putString("contents", contents)
//
//                dealFragment.arguments = bundle
//
////            val transaction = supportFragmentManager.beginTransaction()
////            transaction.add(R.id.frameLayout, fragmentA)
////            transaction.commit()


        //초기화
//        var editor = ApplicationClass.sSharedPreferences.edit()
//        editor.remove("user_name").commit()
//        editor.remove("title").commit()

//        TabLayoutMediator(binding.homeSearchTl,
//            binding.homeSearchVp2) { tab, position ->
//            tab.text = tabLayoutTextArray[position]
//        }.attach()




//            ApplicationClass.sSharedPreferences = getSharedPreferences("title", MODE_PRIVATE)
//            var editor = ApplicationClass.sSharedPreferences.edit()
//            editor.putString("title",title)
//            editor.commit()

//            startActivity(intent)


    }


    private fun replaceView(tab:Fragment){
        var selectedFragment:Fragment?=null
        selectedFragment = tab
        selectedFragment?.let{
            supportFragmentManager.beginTransaction().replace(R.id.home_search_vp2, it).commit()
        }
    }

}