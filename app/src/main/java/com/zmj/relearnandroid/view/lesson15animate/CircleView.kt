package com.zmj.relearnandroid.view.lesson15animate

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.zmj.relearnandroid.view.dp

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-14
 * Description :
 */
class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }
    private var radius = 50.dp



    override fun onDraw(canvas: Canvas) {
        canvas.drawOval(width/2-radius,height/2-radius,width/2+radius,height/2+radius,paint)
    }
}