package com.overz.recycler_view_test.recyclerview_test_ver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.overz.recycler_view_test.R
import com.overz.recycler_view_test.recyclerview_test.Fruit
import kotlinx.android.synthetic.main.activity_recycler_view_ver.*

class RecyclerViewVerActivity : AppCompatActivity() {
    private val fruitListVer = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_ver)

        initFruit()
        val layoutManager = LinearLayoutManager(this)
        recyclerView_ver.layoutManager = layoutManager
        val adapter3 = FruitAdapterVer(fruitListVer)
        recyclerView_ver.adapter = adapter3
    }


    private fun initFruit() {
        repeat(3){
            fruitListVer.add(Fruit("Apple",R.drawable.apple_pic))
            fruitListVer.add(Fruit("Banana",R.drawable.banana_pic))
            fruitListVer.add(Fruit("Orange",R.drawable.orange_pic))
            fruitListVer.add(Fruit("Watermelon",R.drawable.watermelon_pic))
            fruitListVer.add(Fruit("Pear",R.drawable.pear_pic))
            fruitListVer.add(Fruit("Grape",R.drawable.grape_pic))
            fruitListVer.add(Fruit("Pineapple",R.drawable.pineapple_pic))
            fruitListVer.add(Fruit("Strawberry",R.drawable.strawberry_pic))
            fruitListVer.add(Fruit("Cherry",R.drawable.cherry_pic))
            fruitListVer.add(Fruit("Mango",R.drawable.mango_pic))
        }
    }
}