package com.zmj.relearnandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zmj.relearnandroid.view.lesson12Xfermode.XFermodeAct

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun jumpPage(view: View) {
//        val intent = Intent(this,MainActivity2::class.java)
        val intent = Intent(this,com.zmj.relearnandroid.view.lesson11position_size.ViewPositionSizeAct::class.java)
        startActivity(intent)

    }

    fun xFermode(view: View) {
        startActivity(Intent(this,XFermodeAct::class.java))
    }
}