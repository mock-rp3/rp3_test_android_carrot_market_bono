package com.example.carrotmarket.src.config.src.main.btm.home.product.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityHomeSearchBinding
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal.ProductSearchDealFragment
import com.google.android.material.tabs.TabLayoutMediator

class ProductSearchActivity :
    BaseActivity<ActivityHomeSearchBinding>(ActivityHomeSearchBinding::inflate) {


    val tabLayoutTextArray = arrayOf("중고거래", "동네정보", "사람")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.homeSearchVp2.adapter = ProductSearchSliderAdapter(this)

        TabLayoutMediator(binding.homeSearchTl,
            binding.homeSearchVp2) { tab, position ->
            tab.text = tabLayoutTextArray[position]
            if (position == 0) {
//                intent = Intent(this,ProductSearchDealFragment::class.java)
//                intent.putExtra("title",binding.homeSearchEtSearch.text.toString())

                var handled = false
                binding.homeSearchEtSearch.setOnEditorActionListener { v, actionId, event ->
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        ApplicationClass.sSharedPreferences =
                            getSharedPreferences("title", MODE_PRIVATE)
                        var editor = ApplicationClass.sSharedPreferences.edit()
                        editor.putString("title", binding.homeSearchEtSearch.text.toString())
                        Log.e("title1", binding.homeSearchEtSearch.text.toString())
                        editor.commit()
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
            }

//                }
//                binding.homeSearchImgBack.setOnClickListener {
//                    ApplicationClass.sSharedPreferences =
//                        getSharedPreferences("title", MODE_PRIVATE)
//                    var editor = ApplicationClass.sSharedPreferences.edit()
//                    editor.putString("title", binding.homeSearchEtSearch.text.toString())
//                    Log.e("title1", binding.homeSearchEtSearch.text.toString())
//                    editor.commit()
//                }
        }.attach()


        binding.cancelTxt.setOnClickListener {
            binding.cancelTxt.visibility = View.GONE
            binding.invisibleView.visibility = View.GONE
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