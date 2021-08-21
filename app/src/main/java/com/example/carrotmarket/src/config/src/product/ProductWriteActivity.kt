package com.example.carrotmarket.src.config.src.product

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseActivity
import com.example.carrotmarket.databinding.ActivityProductWriteBinding
import com.example.carrotmarket.src.config.src.main.MainActivity
import com.example.carrotmarket.src.config.src.main.btm.LifeFragment

class ProductWriteActivity :
    BaseActivity<ActivityProductWriteBinding>(ActivityProductWriteBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.productWriteImgBack.setOnClickListener {
            intent = Intent(this, LifeFragment::class.java)
            startActivity(intent)
            finish()
        }

        binding.productWriteClCate.setOnClickListener {
            showDialog()
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
        } )
        var alertDialog: AlertDialog = builder.create()
        alertDialog.show()
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