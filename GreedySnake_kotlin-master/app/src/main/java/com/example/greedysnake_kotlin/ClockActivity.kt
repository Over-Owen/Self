package com.example.greedysnake_kotlin

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import kotlinx.android.synthetic.main.activity_clock.*

class ClockActivity : AppCompatActivity() {

    private var mode = 0
    private lateinit var startIntent: Intent
    private lateinit var countDown: CountDownTimer
    private var isStop = false

    private lateinit var clockSound: MediaPlayer

    companion object{
        private var nowTime: Long = 4000
    }

    override fun onStop() {
        super.onStop()
        countDown.cancel()
        countDown = getCountDown(nowTime)
        isStop = true
    }

    override fun onResume() {
        super.onResume()
        Log.e("Msg", "CD Resumed!")
        if (isStop){
            countDown.start()
            isStop = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)

        test()
        initMusic()

        // εζΈθ¨ζ
        countDown = getCountDown(nowTime).start()

    }

    private fun getCountDown(nowTime: Long): CountDownTimer{
        return (object: CountDownTimer(nowTime, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                ClockActivity.nowTime = millisUntilFinished
                when ((millisUntilFinished / 1000).toInt()) {
                    3 -> {countImageView.setImageResource(R.drawable.ic_count_3); clockSound.start()}
                    2 -> {countImageView.setImageResource(R.drawable.ic_count_2); clockSound.start()}
                    1 -> {countImageView.setImageResource(R.drawable.ic_count_1); clockSound.start()}
                    0 -> {countImageView.setImageResource(R.drawable.ic_count_go); clockSound.start()}
                }
            }
            override fun onFinish() {
                ClockActivity.nowTime = 4000
                startActivityForResult(startIntent,1)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        finish()
    }

    private fun test(){
        // εεΎε³ιδΎηζ¨‘εΌ
        intent?.extras?.apply {
            mode = getInt("mode")
            startIntent = Intent(this@ClockActivity, MainActivity::class.java)
            startIntent.putExtra("mode", mode)
        }
    }

    private fun initMusic() {
        clockSound = MediaPlayer.create(this, R.raw.clock_sound)
    }
}