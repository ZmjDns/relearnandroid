package com.zmj.relearnandroid.view.lesson16bitmapdrawable

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.icu.util.DateInterval
import androidx.core.graphics.toColorInt
import com.zmj.relearnandroid.view.dp

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-20
 * Description :
 */

private val INTERVAL = 50.dp
class MeshDrawable: Drawable() {
    private val paint = Paint().apply {
        color = "#F9A825".toColorInt()
        strokeWidth = 5.dp
    }
    override fun draw(canvas: Canvas) {
        //画竖线
        var x = bounds.left.toFloat()
        while (x <= bounds.right) {
            canvas.drawLine(x,bounds.top.toFloat(),x,bounds.bottom.toFloat(),paint)
            x += INTERVAL
        }
        //画横线
        var y = bounds.top.toFloat()
        while (y <= bounds.bottom) {
            canvas.drawLine(bounds.left.toFloat(),y,bounds.right.toFloat(),y,paint)
            y += INTERVAL
        }

    }

    //  设置透明度
    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getAlpha(): Int {
        return paint.alpha
    }

    //  不透明度
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