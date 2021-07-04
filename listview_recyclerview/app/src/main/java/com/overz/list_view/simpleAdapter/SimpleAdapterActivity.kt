package com.overz.list_view.simpleAdapter

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.overz.list_view_recycler_view.R
import kotlinx.android.synthetic.main.activity_simple_adapter.*
import java.util.*

class SimpleAdapterActivity : AppCompatActivity() {
    private val data: MutableList<Map<String, Any>> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_adapter)

        //2.实例化适配器对象

        //参数1：上下文，
        // 参数2：数据，
        initData()
        // 参数3：布局形态资源,
        // 参数4：data资源文件的map中的名称，
        val from = arrayOf("img", "name", "quote")
        // 参数5：xml布局文件中的id名称
        //一一对应
        val to = intArrayOf(R.id.iamge1, R.id.name1, R.id.quote1)
        val adapter2 = SimpleAdapter(this, data, R.layout.item2, from, to)


        //3.为ListView设置适配器
        listView2.adapter = adapter2

        /**
         * item点击事件
         * setOnItemClickListener
         */
        listView2.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                //view 所点击的哪一项的视图
                //position 当前选中的视图的索引！！！！ 可以拿到数据源索引的所有信息
                val map = data[position]
                val name = map["name"].toString()
                val quote = map["quote"].toString()
                Toast.makeText(this, " $name $quote", Toast.LENGTH_SHORT).show()
                Log.d("名言", quote)
            }
    }

    private fun initData() {
        //数据的结构
        //左边头像，右上名字，右下语录
        val map1: MutableMap<String, Any> = HashMap()
        map1["img"] = R.mipmap.ic_launcher_round
        map1["name"] = "小明"
        map1["quote"] = "hahahahahahahahaha"

        val map2: MutableMap<String, Any> = HashMap()
        map2["img"] = R.mipmap.ic_launcher_round
        map2["name"] = "小花"
        map2["quote"] = "hahahahahahahahaha"

        val map3: MutableMap<String, Any> = HashMap()
        map3["img"] = R.mipmap.ic_launcher_round
        map3["name"] = "小芳"
        map3["quote"] = "hahahahahahahahaha"

        val map4: MutableMap<String, Any> = HashMap()
        map4["img"] = R.mipmap.ic_launcher_round
        map4["name"] = "小晴"
        map4["quote"] = "hahahahahahahahaha"

        val map5: MutableMap<String, Any> = HashMap()
        map5["img"] = R.mipmap.ic_launcher_round
        map5["name"] = "小丽"
        map5["quote"] = "hahahahahahahahaha"
        val map6: MutableMap<String, Any> = HashMap()
        map6["img"] = R.mipmap.ic_launcher_round
        map6["name"] = "小芳"
        map6["quote"] = "hahahahahahahahaha"

        val map7: MutableMap<String, Any> = HashMap()
        map7["img"] = R.mipmap.ic_launcher_round
        map7["name"] = "小晴"
        map7["quote"] = "hahahahahahahahaha"

        val map8: MutableMap<String, Any> = HashMap()
        map8["img"] = R.mipmap.ic_launcher_round
        map8["name"] = "小丽"
        map8["quote"] = "hahahahahahahahaha"

        data.add(map1)
        data.add(map2)
        data.add(map3)
        data.add(map4)
        data.add(map5)
        data.add(map6)
        data.add(map7)
        data.add(map8)
    }
}