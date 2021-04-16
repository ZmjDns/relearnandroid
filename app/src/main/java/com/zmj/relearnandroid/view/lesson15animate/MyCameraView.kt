package com.zmj.relearnandroid.view.lesson15animate

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.zmj.relearnandroid.view.dp
import com.zmj.relearnandroid.view.getAvatar

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-15
 * Description :
 */
class MyCameraView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val BITMAP_SIZE = 200.dp
    private val PADDING = 100.dp
    private val bitmap = getAvatar(context!!,BITMAP_SIZE.toInt())

    private var bottomFlip = 0f    //下半部x轴旋转角度
        set(value) {
            field = value
            invalidate()
        }
    private var topFlip = 0f       //上半部x轴旋转角度
        set(value) {
            field = value
            invalidate()
        }

    private var flipAngle = 0f     //canvas旋转角度
        set(value) {
            field = value
            invalidate()
        }

    private val camera = Camera().apply {
        setLocation(0f,0f, Resources.getSystem().displayMetrics.density * -6)
    }

    override fun onDraw(canvas: Canvas) {
        //上半部分
        canvas.save()
        canvas.translate((PADDING+BITMAP_SIZE/2),(PADDING+BITMAP_SIZE/2))
        canvas.rotate(-flipAngle)
        camera.save()
        camera.rotateX(topFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(-BITMAP_SIZE,-BITMAP_SIZE,BITMAP_SIZE,0f)
        canvas.rotate(flipAngle)
        canvas.translate(-(PADDING+BITMAP_SIZE/2),-(PADDING+BITMAP_SIZE/2))
        canvas.drawBitmap(bitmap,PADDING,PADDING,paint)
        canvas.restore()


        //下半部分
        canvas.save()
        canvas.translate((PADDING+BITMAP_SIZE/2),(PADDING+BITMAP_SIZE/2))
        canvas.rotate(-flipAngle)
        camera.save()
        camera.rotateX(bottomFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(-BITMAP_SIZE,0f,BITMAP_SIZE,BITMAP_SIZE)
        canvas.rotate(flipAngle)
        canvas.translate(-(PADDING+BITMAP_SIZE/2),-(PADDING+BITMAP_SIZE/2))
        canvas.drawBitmap(bitmap,PADDING,PADDING,paint)
        canvas.restore()
    }
}