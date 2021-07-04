package com.overz.list_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.overz.list_view.arrayAdapter.ArrayAdapterActivity
import com.overz.list_view.baseAdapter.BaseAdapterActivity
import com.overz.list_view.list_view_test.ListViewActivity
import com.overz.list_view.list_view_test2.ListView2Activity
import com.overz.list_view.simpleAdapter.SimpleAdapterActivity
import com.overz.list_view_recycler_view.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        array_adapter_btn.setOnClickListener {
            val intent = Intent(this,ArrayAdapterActivity::class.java)
            startActivity(intent)
        }
        simple_adapter_btn.setOnClickListener {
            val intent = Intent(this, SimpleAdapterActivity::class.java)
            startActivity(intent)
        }
        base_adapter_btn.setOnClickListener {
            val intent = Intent(this, BaseAdapterActivity::class.java)
            startActivity(intent)
        }
        list_view1_btn.setOnClickListener {
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }
        list_view2_btn.setOnClickListener {
            val intent = Intent(this, ListView2Activity::class.java)
            startActivity(intent)
        }

    }

}