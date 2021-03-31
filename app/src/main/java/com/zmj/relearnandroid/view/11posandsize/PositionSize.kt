package com.zmj.relearnandroid.view.`11posandsize`

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.zmj.relearnandroid.view.dp
import java.lang.Math.toRadians
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-03-27
 * Description :
 */
val OPEN_ANGLE= 120
class TestView(context: Context, attrs: AttributeSet): View(context, attrs) {
    private val RADIUS = 150.dp
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val arcPath = Path()

    private lateinit var pathMeasure: PathMeasure
    private lateinit var effect: PathDashPathEffect

    init {
        paint.strokeWidth = 4.dp
        paint.style = Paint.Style.STROKE
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        arcPath.reset()
        arcPath.addArc(width/2f - RADIUS, height/2f -RADIUS,width/2f + RADIUS, height/2f +  RADIUS,90f + OPEN_ANGLE/2,360f- OPEN_ANGLE)
        pathMeasure = PathMeasure(arcPath, false)

        val dashPath = Path()
        dashPath.addRect(0f,0f,4.dp,10.dp,Path.Direction.CCW)
        effect = PathDashPathEffect(dashPath,(pathMeasure.length - 4.dp)/20,0f,PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas) {

        //刻度
        paint.pathEffect = effect
        canvas.drawPath(arcPath, paint)

        //外圈
        paint.pathEffect = null
        canvas.drawPath(arcPath, paint)

        //指针
        val angle = getAngle(5)
        canvas.drawLine(width/2f, height/2f, width/2 + RADIUS/1.5f * cos(toRadians(angle.toDouble()).toFloat()), height/2 + RADIUS/1.5f * sin(toRadians(angle.toDouble()).toFloat()), paint)

    }

    fun getAngle(num: Int): Float {
        return (360- OPEN_ANGLE)/20 * num + 90 + OPEN_ANGLE/2f
    }
}