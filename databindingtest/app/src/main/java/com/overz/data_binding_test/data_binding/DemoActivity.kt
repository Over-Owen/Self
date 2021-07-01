package com.overz.data_binding_test.data_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.overz.data_binding_test.R
import com.overz.data_binding_test.databinding.ActivityDemoBinding
import android.widget.Toast

class DemoActivity : AppCompatActivity() {
    lateinit var binding: ActivityDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityDemoBinding>(this, R.layout.activity_demo)
        binding.apply {
            name = "Hello Kotlin DataBinding"
            click1 = View.OnClickListener {
                name = "Hello Kotlin DataBinding - OnClickListener "
            }
        }


    }

}