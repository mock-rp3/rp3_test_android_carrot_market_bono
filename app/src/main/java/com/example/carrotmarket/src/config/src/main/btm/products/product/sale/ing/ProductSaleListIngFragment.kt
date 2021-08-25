package com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentProductSaleListIngBinding
import com.example.carrotmarket.src.config.src.main.btm.products.models.ResultHome
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResponse
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResult
import com.example.carrotmarket.src.home.IngAdapter

class ProductSaleListIngFragment : BaseFragment<FragmentProductSaleListIngBinding>(
    FragmentProductSaleListIngBinding::bind,
    R.layout.fragment_product_sale_list_ing), IngView {


    var ingResult = ArrayList<IngResult>()

    private lateinit var ingAdapter: IngAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ingAdapter = IngAdapter(requireActivity(), ingResult)
        binding.ingRv.adapter = ingAdapter
        ApplicationClass.sSharedPreferences = requireActivity().getSharedPreferences(ApplicationClass.X_ACCESS_TOKEN,
            AppCompatActivity.MODE_PRIVATE)

        val jwt = ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, null)

        ApplicationClass.sSharedPreferences =
            requireActivity().getSharedPreferences("userIdx", AppCompatActivity.MODE_PRIVATE)

        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx", 0)


        Log.e("userIdx2", userIdx.toString())

        Log.e("jwt1112323", jwt.toString())

        showLoadingDialog(requireContext())
        IngService(this).tryGetIng(jwt!!,"normal",userIdx)
        ingAdapter.notifyDataSetChanged()


    }

    override fun onGetIngSuccess(response: IngResponse) {

        dismissLoadingDialog()
        //response.result[i].productIdx 순으로 정렬하고 싶음
        for (i in 0 until  response.result.size) {
            ingResult.add(
                IngResult(
                    response.result[i].imageUrl,
                    response.result[i].price,
                    response.result[i].regionNameTown,
                    response.result[i].title,
                    response.result[i].updatedAt,
                    response.result[i].status
                )
            )
        }
        ingAdapter.notifyDataSetChanged()

    }

    override fun onGetIngFailure(message: String) {
    }
}