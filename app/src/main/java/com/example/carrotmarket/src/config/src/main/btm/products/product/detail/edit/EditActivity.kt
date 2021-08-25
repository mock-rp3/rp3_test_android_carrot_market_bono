package com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityEditProductBinding
import com.example.carrotmarket.src.config.src.main.MainActivity
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.ProductDetailActivity
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit.models.EditRequest
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit.models.EditResponse

class EditActivity : BaseActivity<ActivityEditProductBinding>(ActivityEditProductBinding::inflate),
    EditActivityView {
    private var categoryId = 0
    private var canProposal = "N"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        binding.editProductTitle.text = intent.getStringExtra("title").toString()

//        binding.editProductTitle.text= intent.getStringExtra("title")

        binding.editProductClCate.setOnClickListener {
            showDialog()
        }

        binding.editProductPrice.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.editProductPrice.length() > 0) {
                    binding.editProductPrice.setTextColor(Color.parseColor("#000000"))
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })


        binding.editProductCbPricePro.setOnClickListener {
            if (binding.editProductCbPricePro.isChecked == true) {
                canProposal = "Y"
            } else {
                canProposal = "N"
            }
        }


        val productIdx = intent.getIntExtra("productIdx", 0)

        binding.editProductComp.setOnClickListener {
            val title = binding.editProductTitle.text.toString()
            val price = binding.editProductPrice.text.toString()
            val contents = binding.editProductContents.text.toString()

            val editRequest = EditRequest(
                title = title,
                contents = contents,
                price = price.toInt(),
                canProposal = canProposal,
                categoryId = categoryId,
                imageUrl = "test",
            )


            Log.e("productIdx", intent.getIntExtra("productIdx", 0).toString())
            Log.e("productIdx1", productIdx.toString())

            EditService(this).tryPatchProductDetail(productIdx, editRequest)

        }

        binding.editProductImgBack.setOnClickListener {
            intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun showDialog() {
        val write_cate = resources.getStringArray(R.array.write_cate)

        val builder = AlertDialog.Builder(this)
        builder.setItems(write_cate, DialogInterface.OnClickListener { dialog, which ->
            binding.editProductTxtCate.text = write_cate[which].toString()
            categoryId = which + 2
            Log.e("categoryId", categoryId.toString())
        })
        var alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    override fun onPatchProductDetailSuccess(response: EditResponse) {

        intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("cate", binding.editProductTxtCate.text )
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()

    }

    override fun onPatchProductDetailFailure(message: String) {
    }


}