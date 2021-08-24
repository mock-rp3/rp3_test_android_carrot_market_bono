package com.example.carrotmarket.src.config.src.main.btm.home.product.writing

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.R
import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityProductWritingBinding
import com.example.carrotmarket.src.config.src.main.MainActivity
import com.example.carrotmarket.src.config.src.main.btm.home.models.ResultHome
import com.example.carrotmarket.src.config.src.main.btm.home.product.detail.images
import com.example.carrotmarket.src.config.src.main.btm.home.product.search.deal.models.ResultSearchDeal

import com.example.carrotmarket.src.config.src.main.btm.home.product.writing.models.RequestPostWriting
import com.example.carrotmarket.src.config.src.main.btm.home.product.writing.models.ResponseWriting
import com.example.carrotmarket.src.home.HomeFragment


class ProductWritingActivity :
    BaseActivity<ActivityProductWritingBinding>(ActivityProductWritingBinding::inflate),
    ProductWritingActivityView {


    private var categoryId = 0
    private var canProposal = "N"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //카테고리
        binding.productWriteClCate.setOnClickListener {
            showDialog()
        }

        //edittext 글자 변화
        binding.productWritePrice.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.productWritePrice.length() > 0) {
                    binding.productWritePricePro.setTextColor(Color.parseColor("#000000"))
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        //체크박스 상태변화
        binding.productWriteCbPricePro.setOnClickListener {
            if (binding.productWriteCbPricePro.isChecked == true) {
                canProposal = "Y"
            } else {
                canProposal = "N"
            }
        }

        // userIdx 가져오기
        ApplicationClass.sSharedPreferences = getSharedPreferences("userIdx", AppCompatActivity.MODE_PRIVATE)

        val userIdx = ApplicationClass.sSharedPreferences.getInt("userIdx", 0)
        Log.e("userIdx2", userIdx.toString())


        binding.productWriteComp.setOnClickListener {
            val title = binding.productWriteTitle.text.toString()
            val price = binding.productWritePrice.text.toString()
            val contents = binding.productWriteContents.text.toString()

            val requestPostWriting = RequestPostWriting(
                title = title,
                price = price.toInt(),
                canProposal = canProposal,
                categoryId = categoryId,
                sellerId = userIdx,
                imageUrl = "test",
                contents = contents
            )
            ProductWritingService(this).tryPostProductWriting(requestPostWriting)
            //                        intent.putExtra("phoneNumber", binding.signUpMainEdtId.text.toString())
            //                        intent.putExtra("password", binding.signUpMainEdtPwd.text.toString())
//            intent.putExtra("title",title)
//            intent.putExtra("price",price)
//            intent.putExtra("canProposal",canProposal)
//            intent.putExtra("categoryId",categoryId)
//            intent.putExtra("sellerId",userIdx)
//            intent.putExtra("imageUrl", "test")
//            intent.putExtra("contents",contents)




//            supportFragmentManager.beginTransaction().replace()(
//                R.id
//            )

//            val bundle = Bundle()
//            bundle.putString("title", title)
//            bundle.putInt("price", price.toInt())
//            bundle.putString("canProposal", canProposal)
//            bundle.putInt("categoryId", categoryId)
//            bundle.putInt("sellerId", userIdx)
//            bundle.putString("imageUrl", "test")
//            bundle.putString("contents", contents)
//
//            val homeFragment = HomeFragment()
//            homeFragment.arguments = bundle
//
//
////            val transaction = supportFragmentManager.beginTransaction()
////            transaction.add(R.id.frameLayout, fragmentA)
////            transaction.commit()
//
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.add(R.id.main_frm, homeFragment)
//            transaction.commit()



        }

        binding.productWriteImgBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

//            val p=PopupMenu(applicationContext, binding.productWriteClCate)
//            menuInflater.inflate(R.menu.menu_product_write_category,
//                p.menu)
//            p.show()

    }

    fun showDialog() {
        val write_cate = resources.getStringArray(R.array.write_cate)

        val builder = AlertDialog.Builder(this)
        builder.setItems(write_cate, DialogInterface.OnClickListener { dialog, which ->
            binding.productWriteTxtCate.text = write_cate[which].toString()
            categoryId = which + 2
            Log.e("categoryId", categoryId.toString())
        })
        var alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    override fun onPostProductWritingSuccess(response: ResponseWriting) {
        intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
        finish()
//        title = title,
//        price = price.toInt(),
//        canProposal = canProposal,
//        categoryId = categoryId,
//        sellerId = userIdx,
//        imageUrl = "test",
//        contents = contents


//        val bundle = Bundle()
//        bundle.putInt("productIdx", response.result.productIdx)
//
//        val homeFragment = HomeFragment()
//        homeFragment.arguments = bundle
//
//
////            val transaction = supportFragmentManager.beginTransaction()
////            transaction.add(R.id.frameLayout, fragmentA)
////            transaction.commit()
//
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.main_frm, homeFragment)
//        transaction.commit()


    }

    override fun onPostProductWritingFailure(message: String) {
    }


//    override fun onCreateContextMenu(
//        menu: ContextMenu?,
//        v: View?,
//        menuInfo: ContextMenu.ContextMenuInfo?,
//    ) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//            menuInflater.inflate(R.menu.menu_product_write_category, menu)
//
//    }
//
//    override fun onContextItemSelected(item: MenuItem): Boolean {
//
//        when(item?.itemId){
//            R.id.home_category_digital -> binding.productWriteTxtCate.text="hi"
//        }
//
//        return super.onContextItemSelected(item)
//
//    }

}