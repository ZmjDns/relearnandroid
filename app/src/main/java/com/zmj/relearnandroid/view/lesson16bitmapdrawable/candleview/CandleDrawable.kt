package com.zmj.relearnandroid.view.lesson16bitmapdrawable.candleview

import android.graphics.*
import android.graphics.drawable.Drawable
import com.zmj.relearnandroid.view.dp

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-20
 * Description :
 */
private val LINE_WIDTH = 2.dp
private val CANDLE_WIDTH = 20.dp
class CandleDrawable: Drawable() {
    private val paint = Paint().apply {
        color = Color.RED
    }

    override fun draw(canvas: Canvas) {
        //先画线
//        paint.strokeWidth = LINE_WIDTH
        val lineLeft = (bounds.right - bounds.left - LINE_WIDTH) / 2f
        canvas.drawRect(lineLeft,bounds.top.toFloat(),lineLeft + LINE_WIDTH,bounds.bottom.toFloat(),paint)
        //画蜡烛
//        paint.strokeWidth = CANDLE_WIDTH
        val canLeft = (bounds.right - bounds.left - CANDLE_WIDTH) / 2f
        val canHeight = (bounds.bottom - bounds.top) / 3 * 2f
        canvas.drawRect(canLeft,(bounds.top + canHeight/2f),canLeft + CANDLE_WIDTH,(bounds.bottom - canHeight/2),paint)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getAlpha(): Int {
        return paint.alpha
    }

    override fun getOpacity(): Int {
        return when(paint.alpha) {
            0 -> PixelFormat.TRANSPARENT
            0xff -> PixelFormat.OPAQUE
            else -> PixelFormat.TRANSLUCENT
        }
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getColorFilter(): ColorFilter? {
        return paint.colorFilter
    }
}