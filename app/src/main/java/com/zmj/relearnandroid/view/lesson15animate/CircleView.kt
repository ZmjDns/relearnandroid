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
        strokeWidth = 20.dp
        style = Paint.Style.STROKE
    }
    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.YELLOW
        strokeWidth = 20.dp
        style = Paint.Style.STROKE
    }
    private val paint3 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.GREEN
        strokeWidth = 20.dp
        style = Paint.Style.STROKE
    }
    private var radius = 100.dp
        set(value) {
            field = value
            invalidate()
        }
    private var sweepAngle = 0f
        set(value) {
            field = value
            invalidate()
        }


    override fun onDraw(canvas: Canvas) {
//        canvas.drawOval(width/2-radius,height/2-radius,width/2+radius,height/2+radius,paint)

        if (sweepAngle <360) {
            canvas.save()
            canvas.drawArc(width/2-radius,height/2-radius,width/2+radius,height/2+radius,0f,sweepAngle,false,paint)
            canvas.restore()
        } else if (sweepAngle >= 360 && sweepAngle < 720) {
            canvas.save()
            canvas.drawArc(width/2-radius,height/2-radius,width/2+radius,height/2+radius,360f,sweepAngle,false,paint2)
            canvas.restore()
        } else if (sweepAngle >= 720) {
            canvas.save()
            canvas.drawArc(width/2-radius,height/2-radius,width/2+radius,height/2+radius,720f,sweepAngle,false,paint3)
            canvas.restore()
        }
    }
}