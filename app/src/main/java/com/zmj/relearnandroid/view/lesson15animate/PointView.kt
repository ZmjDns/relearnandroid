package com.zmj.relearnandroid.view.lesson15animate

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.zmj.relearnandroid.view.dp

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-18
 * Description :
 */
class PointView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    //此处内部属性不能写成private，否则执行动画没有效果
    var point = PointF(0f,0f)
        set(value) {
            field = value
            invalidate()
        }
    init {
        paint.strokeWidth = 20.dp
        paint.strokeCap = Paint.Cap.ROUND
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPoint(point.x,point.y,paint)
    }
}