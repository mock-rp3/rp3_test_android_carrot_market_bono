package com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.databinding.FragmentProductSaleListIngBinding
import com.example.carrotmarket.src.config.src.main.btm.products.models.ResultHome
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResponse
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResult
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.models.StatusRequest
import com.example.carrotmarket.src.home.IngAdapter

class ProductSaleListIngFragment : BaseFragment<FragmentProductSaleListIngBinding>(
    FragmentProductSaleListIngBinding::bind,
    R.layout.fragment_product_sale_list_ing), IngView, AdapterView {


    var ingResult = ArrayList<IngResult>()

    private lateinit var ingAdapter: IngAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ingAdapter = IngAdapter(requireActivity(), ingResult)
        binding.ingRv.adapter = ingAdapter


        ApplicationClass.sSharedPreferences =
            requireActivity().getSharedPreferences(ApplicationClass.X_ACCESS_TOKEN,
                AppCompatActivity.MODE_PRIVATE)

        val jwt =
            ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, null)

        ApplicationClass.sSharedPreferences =
            requireActivity().getSharedPreferences("userIdx", AppCompatActivity.MODE_PRIVATE)

        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx", 0)


        Log.e("userIdx2", userIdx.toString())

        Log.e("jwt1112323", jwt.toString())

        showLoadingDialog(requireContext())
        IngService(this).tryGetIng(jwt!!, "normal", userIdx)
        ingAdapter.notifyDataSetChanged()

//        val statusIngRequest = StatusRequest(
//
//            productId =productDataList[position].productId,
//            status = "reserved"
//        )
//        val statusCompRequest = StatusRequest(
//
//            productId =productDataList[position].productId,
//            status = "traded"
//        )
//
//
//
//            Log.e("id",productDataList[position].productId.toString())
//
//            AdapterService(this).tryPatchStatus(statusIngRequest)
//
//            Log.e("status",statusCompRequest.toString())
//
//            AdapterService(this).tryPatchStatus(statusCompRequest)
//        }
    }

    override fun onGetIngSuccess(response: IngResponse) {

        dismissLoadingDialog()
        Log.e("size", ingAdapter.productDataList.size.toString())
        Log.e("size2", ingResult.size.toString())
        Log.e("size3", response.result.size.toString())
        for (i in response.result.indices) {
            ingResult.add(
                IngResult(
                    response.result[i].imageUrl,
                    response.result[i].price,
                    response.result[i].regionNameTown,
                    response.result[i].title,
                    response.result[i].updatedAt,
                    response.result[i].status,
                    response.result[i].productId
                )
            )
//            Log.e("dasdas",response.result[i].status.toString())

        }
        ingAdapter.notifyDataSetChanged()

//        for (i in 0..response.result.size) {
//
////            Log.e("status", statusCompRequest.toString())
//
//            if (response.result[i].status == "reserved") {
//                val statusIngRequest = StatusRequest(
//                    productId = response.result[i].productId,
//                    status = "reserved"
//                )
//                AdapterService(this).tryPatchStatus(statusIngRequest)
//            }
//            if (response.result[i].status == "traded") {
//                val statusCompRequest = StatusRequest(
//                    productId = response.result[i].productId,
//                    status = "traded"
//                )
//                AdapterService(this).tryPatchStatus(statusCompRequest)
//            }
//        }
    }


    override fun onGetIngFailure(message: String) {
    }

    override fun onPatchStatusSuccess(response: BaseResponse) {

    }

    override fun onPatchStatusFailure(message: String) {
    }


}