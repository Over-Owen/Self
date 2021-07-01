package com.overz.viewmodel_test


import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.overz.viewmodel_test.b_viewmodel.MainViewModel
import com.overz.viewmodel_test.b_viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sharedPreferences.getInt("count_reserved", 0)
        text_number.text = countReserved.toString()
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(countReserved)
        ).get(MainViewModel::class.java)
        plus_number_btn.setOnClickListener {
            viewModel.plusOne()
        }
        clear_btn.setOnClickListener {
            text_number.text = 0.toString()
            viewModel.clear()
        }
        viewModel.counter.observe(this, Observer { count ->
            text_number.text = count.toString()
        })
    }

    override fun onPause() {
        super.onPause()
        sharedPreferences.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }

    private fun refreshCounter() {
        text_number.text = viewModel.counter.toString()
    }
}