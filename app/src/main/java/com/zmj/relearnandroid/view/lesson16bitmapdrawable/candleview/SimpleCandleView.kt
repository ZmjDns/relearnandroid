package com.zmj.relearnandroid.view.lesson16bitmapdrawable.candleview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.zmj.relearnandroid.view.dp
import com.zmj.relearnandroid.view.lesson16bitmapdrawable.MeshDrawable

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-20
 * Description :
 */
class SimpleCandleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val drawable = CandleDrawable()
    private val meshDrawable = MeshDrawable()
    private val CANWIDTH = 50.dp.toInt()
    private val INTERVAL = 300.dp.toInt()

    override fun onDraw(canvas: Canvas) {
        // 画网格
        canvas.save()
        meshDrawable.setBounds(0,0,width,height)
        meshDrawable.draw(canvas)
        canvas.restore()
        //画candle

        /*var left = 0
        val top = 20.dp.toInt()
        var right = left + CANWIDTH
        val bottom = top + 80.dp.toInt()
        for (i in 0..2) {
            drawable.setBounds(left,top,right,bottom)
            drawable.draw(canvas)
            left += CANWIDTH + INTERVAL
            right += CANWIDTH + INTERVAL
        }*/


        drawable.setBounds(left,20.dp.toInt(),left + 50.dp.toInt(),100.dp.toInt())
        drawable.draw(canvas)

        drawable.setBounds(left + 180.dp.toInt(),40.dp.toInt(),left + 300.dp.toInt(),120.dp.toInt())
        drawable.draw(canvas)

    }
}