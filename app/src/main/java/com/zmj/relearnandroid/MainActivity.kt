package com.zmj.relearnandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zmj.relearnandroid.view.lesson12Xfermode.XFermodeAct
import com.zmj.relearnandroid.view.lesson13textmeasure.TextMeasureAct
import com.zmj.relearnandroid.view.lesson14cliptrans.ClipAndTransAct
import com.zmj.relearnandroid.view.lesson15animate.AnimateAct
import com.zmj.relearnandroid.view.lesson16bitmapdrawable.BitmapDrawableAct
import com.zmj.relearnandroid.view.lesson17materialtext.MaterialEditTextAct

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

    fun textMeasure(view: View) {
        startActivity(Intent(this,TextMeasureAct::class.java))
    }

    fun clipAndTrans(view: View) {
        startActivity(Intent(this,ClipAndTransAct::class.java))
    }

    fun animate(view: View) {
        startActivity(Intent(this,AnimateAct::class.java))
    }

    fun drawableBitmap(view: View) {
        startActivity(Intent(this,BitmapDrawableAct::class.java))
    }

    fun materialText(view: View) {
        startActivity(Intent(this,MaterialEditTextAct::class.java))
    }











    fun constraintLayout(view: View) {
        startActivity(Intent(this,MaterialEditTextAct::class.java))
    }
}