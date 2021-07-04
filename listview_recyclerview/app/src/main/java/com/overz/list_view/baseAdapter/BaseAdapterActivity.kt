package com.overz.list_view.baseAdapter

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.overz.list_view_recycler_view.R
import kotlinx.android.synthetic.main.activity_base_adapter.*
import java.util.*

class BaseAdapterActivity : AppCompatActivity() {

    private var listView3: ListView? = null
    private val list: MutableList<Msg> = ArrayList<Msg>()
    private val user_avatar = intArrayOf(
        R.mipmap.ic_launcher_round,
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher_round,
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher_round,
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher_round,
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher_round,
        R.mipmap.ic_launcher
    )

    //需要传的参数：上下文，数据源
    private var adapter4: BaseAdapter = MyBaseAdapter(list, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_adapter)

        //数据源
        initData()        //设置适配器
        listView3?.adapter = adapter4

        //add点击事件
        add_btn.setOnClickListener {
            val m =
                Msg(R.mipmap.ic_launcher_round, "小明", "2021-07-04", "6666666666666666666！", false)
            list.add(m)
            Toast.makeText(this, "动态添加", Toast.LENGTH_SHORT).show()

            //通知适配器更新数据
            adapter4.notifyDataSetChanged()
            //设置ListView自动显示到最新数据，滚动到最新位置
            listView3?.transcriptMode = AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL
        }

    }

    private fun initData() {
        for (i in 1..8) {
            val m = Msg(user_avatar[i - 1], "用户$i", "2021-07-04", "今天也要加油哦！$i", i % 2 != 0)
            list.add(m)
        }
    }
}