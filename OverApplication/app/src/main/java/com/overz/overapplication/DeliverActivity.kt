package com.overz.overapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class DeliverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deliver)
        //getStringData获取获取传递的字符串
        //括号中的 name: "extra_data" 要与上一个Activity中参数名相同
        val extraData = intent.getStringExtra("extra_data")
        Toast.makeText(this, "传递的数据为：$extraData", Toast.LENGTH_SHORT).show()
        Log.d("DeliverActivity", "传递的数据为：$extraData")
    }
}