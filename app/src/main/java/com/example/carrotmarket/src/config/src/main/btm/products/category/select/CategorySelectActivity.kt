package com.example.carrotmarket.src.config.src.main.btm.products.category.select

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityCategorySelectBinding
import com.example.carrotmarket.src.config.src.main.btm.products.category.HomeCategoryActivity
import com.example.carrotmarket.src.config.src.main.btm.products.category.select.models.CategorySelectResponse
import com.example.carrotmarket.src.config.src.main.btm.products.category.select.models.CategorySelectResult

class CategorySelectActivity:BaseActivity<ActivityCategorySelectBinding>(ActivityCategorySelectBinding::inflate),
CategorySelectView{

    var categoryResponse = ArrayList<CategorySelectResult>()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        productAdapter = ProductAdapter(this, categoryResponse)
        binding.homeRv.adapter = productAdapter
        binding.cateMainTxt.text=intent.getStringExtra("categoryName")
        val category=intent.getIntExtra("category",0)

        Log.e("categoryMain",category.toString())


        showLoadingDialog(this)
        val dividerItemDecoration = DividerItemDecoration(
            this, LinearLayoutManager(this).orientation)
        binding.homeRv.addItemDecoration(dividerItemDecoration)

        CategorySelectService(this).tryGetCategory(category)

        binding.cateImgBack.setOnClickListener {
            intent= Intent(this, HomeCategoryActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onGetCategorySuccess(response: CategorySelectResponse) {

        dismissLoadingDialog()
        //response.result[i].productIdx 순으로 정렬하고 싶음
        for (i in 0 until  response.result.size) {
            categoryResponse.add(
                CategorySelectResult(
                    response.result[i].productIdx,
                    response.result[i].imageUrl,
                    response.result[i].title,
                    response.result[i].regionNameTown,
                    response.result[i].pulledAt,
                    response.result[i].price,
                    response.result[i].wishCount
                )
            )
        }
        productAdapter.notifyDataSetChanged()


    }

    override fun onGetCategoryFailure(message: String) {

    }
}



