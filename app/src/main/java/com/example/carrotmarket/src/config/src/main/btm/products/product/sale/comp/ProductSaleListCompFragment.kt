package com.example.carrotmarket.src.config.src.main.btm.products.product.sale.comp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentProductSaleListCompBinding
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.IngService
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.IngView
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResponse
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResult
import com.example.carrotmarket.src.home.CompAdapter
import com.example.carrotmarket.src.home.IngAdapter

class ProductSaleListCompFragment : BaseFragment<FragmentProductSaleListCompBinding>(
    FragmentProductSaleListCompBinding::bind,
    R.layout.fragment_product_sale_list_comp),
    IngView {

    var ingResult = ArrayList<IngResult>()

    private lateinit var compAdapter: CompAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        compAdapter = CompAdapter(requireActivity(), ingResult)
        binding.ingRv.adapter = compAdapter

        ApplicationClass.sSharedPreferences = requireActivity().getSharedPreferences(
            ApplicationClass.X_ACCESS_TOKEN,
            AppCompatActivity.MODE_PRIVATE)

        val jwt =
            ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, null)

        ApplicationClass.sSharedPreferences =
            requireActivity().getSharedPreferences("userIdx", AppCompatActivity.MODE_PRIVATE)

        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx", 0)


        Log.e("userIdx2", userIdx.toString())

        Log.e("jwt1112323", jwt.toString())

        showLoadingDialog(requireContext())
        IngService(this).tryGetIng(jwt!!, "traded", userIdx)


    }

    override fun onGetIngSuccess(response: IngResponse) {
        dismissLoadingDialog()


        for (i in response.result.indices) {

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

        compAdapter.notifyDataSetChanged()
    }

    override fun onGetIngFailure(message: String) {
    }
}