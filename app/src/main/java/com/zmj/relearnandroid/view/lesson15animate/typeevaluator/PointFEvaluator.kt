package com.zmj.relearnandroid.view.lesson15animate.typeevaluator

import android.animation.TypeEvaluator
import android.graphics.PointF
import androidx.core.graphics.plus

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-18
 * Description :
 */
class PointFEvaluator: TypeEvaluator<PointF> {
    override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
        val startX = startValue.x
        val  endX = endValue.x
        val currentX = startX + (endX - startX) * fraction

        val startY = startValue.y
        val endY = endValue.y
        val currentY = startY + (endY - startY) * fraction

        return PointF(currentX,currentY)
    }
}