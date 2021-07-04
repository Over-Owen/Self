package com.overz.list_view.arrayAdapter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.overz.list_view_recycler_view.R

class ArrayAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_adapter)

        //找到listView控件
        //找到listView控件
        val listView1 = findViewById<ListView>(R.id.listView1)

        //2.准备数据源

        //2.准备数据源
        val data = arrayOf<String?>(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M"
        )

        //3.实例化适配器
        //参数1：上下文this，参数2：每一项数据所显示的布局形态，参数3：数据源object

        //3.实例化适配器
        //参数1：上下文this，参数2：每一项数据所显示的布局形态，参数3：数据源object
        val adapter1: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, R.layout.item, R.id.text_view, data)

        //4.设置适配器

        //4.设置适配器
        listView1.adapter = adapter1
    }
}