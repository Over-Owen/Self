package com.overz.list_view_recycler_view.list_view_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.overz.list_view_recycler_view.R
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    private val data = listOf("apple","orange","banana","watermelon","apple","orange","banana","watermelon","apple","orange","banana","watermelon","apple","orange","banana","watermelon","apple","orange","banana","watermelon","apple","orange","banana","watermelon","apple","orange","banana","watermelon","apple","orange","banana","watermelon","apple","orange","banana","watermelon")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val adapter1 = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
        listView.adapter = adapter1
    }
}