package com.zmj.relearnandroid.view.lesson13textmeasure

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
 * Time : 2021-04-10
 * Description :
 */
class SportView(context: Context,attrs: AttributeSet): View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val BG_COLOR = Color.GRAY
    private val DONE_COLOR =Color.parseColor("#FF4081")
    private val STROKE_WIDTH = 20.dp
    private val RADIUS = 100.dp


    override fun onDraw(canvas: Canvas) {
        paint.strokeWidth = STROKE_WIDTH
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        //绘制背景环
        paint.color = BG_COLOR
        canvas.drawCircle(width/2f, height/2f, RADIUS, paint)
        //绘制进度条
        paint.color = DONE_COLOR
        canvas.drawArc(width/2-RADIUS,height/2-RADIUS,width/2+RADIUS,height/2+RADIUS,-100f,200f,false,paint)
        //绘制文字
        paint.style = Paint.Style.FILL
        paint.textSize = 40.dp
        canvas.drawText("abab",width/2f,height/2f,paint)
    }
}