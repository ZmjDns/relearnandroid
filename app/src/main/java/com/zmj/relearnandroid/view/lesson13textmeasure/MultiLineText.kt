package com.zmj.relearnandroid.view.lesson13textmeasure

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.zmj.relearnandroid.view.dp
import com.zmj.relearnandroid.view.getAvatar

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-10
 * Description :
 */
class MultiLineText(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val text = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc."
    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 16.dp
    }

    private val bitmap = getAvatar(context!!,150.dp.toInt())
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var fontMetrics = Paint.FontMetrics()

    override fun onDraw(canvas: Canvas) {
//        val staticLayout = StaticLayout(text,textPaint,width,Layout.Alignment.ALIGN_NORMAL,1f,0f,false)
//        staticLayout.draw(canvas)
        canvas.drawBitmap(bitmap,width - 150.dp,50.dp,paint)

        fontMetrics = textPaint.fontMetrics

        var start = 0
        var count: Int
        val textMeasure = floatArrayOf()
        var verticalOffset = -fontMetrics.top
        var maxWidth: Float
        while (start < text.length) {
            maxWidth = if (verticalOffset + fontMetrics.bottom < 50.dp || verticalOffset + fontMetrics.top > 50.dp + bitmap.height) {
                width.toFloat()
            }else {
                width.toFloat() - bitmap.width
            }
            count = textPaint.breakText(text,start,text.length,true,maxWidth,textMeasure)
            canvas.drawText(text,start,start + count,0f,verticalOffset,textPaint)
            start += count
            verticalOffset += textPaint.fontSpacing
        }

    }
}