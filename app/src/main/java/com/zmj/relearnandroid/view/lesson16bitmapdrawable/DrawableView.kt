package com.zmj.relearnandroid.view.lesson16bitmapdrawable

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.View
import com.zmj.relearnandroid.view.dp
import com.zmj.relearnandroid.view.lesson16bitmapdrawable.candleview.CandleDrawable

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-20
 * Description :
 */
class DrawableView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
//    private val drawable = ColorDrawable(Color.RED)
    private val  drawable = MeshDrawable()

    override fun onDraw(canvas: Canvas) {

        drawable.setBounds(0.dp.toInt(),0.dp.toInt(),width,height)
        drawable.draw(canvas)
    }
}