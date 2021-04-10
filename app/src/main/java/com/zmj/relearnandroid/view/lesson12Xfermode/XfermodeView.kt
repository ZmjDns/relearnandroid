package com.zmj.relearnandroid.view.lesson12Xfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.zmj.relearnandroid.view.dp

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-07
 * Description :
 */
class XfermodeView(context: Context, attrs: AttributeSet): View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(150f,50f,300.dp,200.dp)  //  离屏缓冲区域，背景和目标存在的区域
    private val xFermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)  // SRC_IN   SRC_OUT。。。

    private val circelBitmap = Bitmap.createBitmap(150.dp.toInt(),150.dp.toInt(),Bitmap.Config.ARGB_8888)
    private val squareBitmap = Bitmap.createBitmap(150.dp.toInt(),150.dp.toInt(),Bitmap.Config.ARGB_8888)

    init {
        val canvas = Canvas(circelBitmap)
        paint.color = Color.parseColor("#D81B60")
        canvas.drawOval(50.dp,0.dp,150.dp,100.dp,paint)
        canvas.setBitmap(squareBitmap)
        paint.color = Color.BLUE
        canvas.drawRect(0.dp,50.dp,100.dp,150.dp, paint)
    }

    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(bounds, null)  //设置离屏缓冲

        canvas.drawBitmap(circelBitmap,150.dp,50.dp,paint)
        paint.xfermode = xFermode
        canvas.drawBitmap(squareBitmap,150.dp,50.dp,paint)
        paint.xfermode = null
        canvas.restoreToCount(count)

    }

}