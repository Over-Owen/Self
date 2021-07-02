package com.overz.recycler_view_test.recyclerview_test

import FruitAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.overz.recycler_view_test.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        initFruit()
        val layoutManager = LinearLayoutManager(this)
        recyclerView_test.layoutManager = layoutManager
        val adapter3 = FruitAdapter(fruitList)
        recyclerView_test.adapter = adapter3
    }


    private fun initFruit() {
        repeat(3){
            fruitList.add(Fruit("Apple",R.drawable.apple_pic))
            fruitList.add(Fruit("Banana",R.drawable.banana_pic))
            fruitList.add(Fruit("Orange",R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon",R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear",R.drawable.pear_pic))
            fruitList.add(Fruit("Grape",R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple",R.drawable.pineapple_pic))
            fruitList.add(Fruit("Strawberry",R.drawable.strawberry_pic))
            fruitList.add(Fruit("Cherry",R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango",R.drawable.mango_pic))
        }
    }
}