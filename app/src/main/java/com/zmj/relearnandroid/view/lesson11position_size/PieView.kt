package com.zmj.relearnandroid.view.lesson11position_size

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.zmj.relearnandroid.view.dp
import kotlin.math.cos
import kotlin.math.sin

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-02
 * Description :
 */
class PieView(context: Context,attrs: AttributeSet): View(context, attrs){
    private val RADIUS = 150.dp
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private lateinit var rectF: RectF
    private val colors = arrayOf(Color.BLACK,Color.parseColor("#2356AB"), Color.RED,Color.BLUE,Color.YELLOW)
    private val angles = arrayOf(60f,80f,100f,60f,60f)


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        rectF = RectF(width/2 - RADIUS,height/2 - RADIUS, width/2 + RADIUS, height/2 + RADIUS)

    }


    override fun onDraw(canvas: Canvas) {
//        canvas.drawColor(Color.RED)
//        canvas.drawRect(rectF,paint)
        var startAngle = 0f
        for (index in angles.indices) {
            paint.color = colors[index]
            if (index == 4) {
                canvas.save()
                canvas.translate(cos(Math.toRadians((startAngle + angles[index]/2).toDouble())).toFloat() * 20.dp, sin(Math.toRadians((startAngle + angles[index]/2).toDouble())).toFloat()* 20.dp)
                canvas.drawArc(rectF,startAngle,angles[index],true,paint)
                canvas.restore()
            } else {
                canvas.drawArc(rectF,startAngle,angles[index],true,paint)
            }
            startAngle += angles[index]
        }

//        paint.color = Color.BLACK
//        canvas.drawArc(rectF, 0f,60f,true,paint)
//        paint.color = Color.parseColor("#2356AB")
//        canvas.drawArc(rectF,60f,80f,true,paint)
//        canvas.save()
//        canvas.translate(-10.dp,0.dp)
//        paint.color = Color.RED
//        canvas.drawArc(rectF, 140f,100f,true,paint)
//        canvas.restore()
//        paint.color = Color.BLUE
//        canvas.drawArc(rectF, 240f,60f,true,paint)
//        paint.color = Color.YELLOW
//        canvas.drawArc(rectF, 300f,60f,true,paint)
    }
}