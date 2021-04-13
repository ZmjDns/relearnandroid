package com.zmj.relearnandroid.view.lesson15animate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zmj.relearnandroid.R
import com.zmj.relearnandroid.view.dp
import kotlinx.android.synthetic.main.act_animate.*

class AnimateAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_animate)

        avator.animate()
            .translationX(100.dp).startDelay = 1000
    }
}