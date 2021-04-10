package com.zmj.relearnandroid.view.lesson13textmeasure

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.zmj.relearnandroid.R
import com.zmj.relearnandroid.view.dp

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-10
 * Description :
 */
class SportView(context: Context,attrs: AttributeSet): View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 100.dp
        typeface = ResourcesCompat.getFont(context, R.font.font)
        textAlign = Paint.Align.CENTER
    }
    private val BG_COLOR = Color.GRAY
    private val DONE_COLOR =Color.parseColor("#FF4081")
    private val STROKE_WIDTH = 14.dp
    private val RADIUS = 140.dp

    private var text = "abab"
    private var textBounds = Rect()

    private val fontMetrics = Paint.FontMetrics()


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
//        paint.getTextBounds(text,0,text.length,textBounds)    //适合金静态文字
//        canvas.drawText(text,width/2f,width/2f,paint)

        paint.getFontMetrics(fontMetrics)   //适合动态文字
        canvas.drawText(text,width/2f,height/2f - (fontMetrics.ascent + fontMetrics.descent)/2f, paint)
    }
}