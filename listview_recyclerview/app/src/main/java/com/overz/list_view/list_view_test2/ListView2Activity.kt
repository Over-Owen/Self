package com.overz.list_view.list_view_test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.overz.list_view_recycler_view.R
import kotlinx.android.synthetic.main.activity_list_view2.*

class ListView2Activity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view2)

        initFruit()
        val adapter2 = FruitAdapter(this,R.layout.fruit_item,fruitList)
        listView2.adapter = adapter2
        listView2.setOnItemClickListener { parent, view, position, id ->
            val fruit = fruitList[position]
            Toast.makeText(this,fruit.name,Toast.LENGTH_SHORT).show()
        }
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