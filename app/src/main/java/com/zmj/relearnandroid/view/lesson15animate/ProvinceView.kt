package com.zmj.relearnandroid.view.lesson15animate

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.zmj.relearnandroid.view.dp
import kotlinx.android.synthetic.main.act_animate.view.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-19
 * Description :
 */
class ProvinceView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint()

    var province = "北京市"
        set(value) {
            field = value
            invalidate()
        }

    init {
        paint.textSize = 50.dp
        paint.textAlign = Paint.Align.CENTER

        /*setLayerType(LAYER_TYPE_HARDWARE,null)  //离屏缓冲使用硬件来绘制
        setLayerType(LAYER_TYPE_SOFTWARE,null)  //离屏缓冲使用软件来绘制，（如果全局开启了硬件加速，在绘制这个VIew的时候会关闭这个view的硬件加速）
        setLayerType(LAYER_TYPE_NONE,null)      //关闭离屏缓冲*/
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawText(province,width/2f,height/2f,paint)
    }
}