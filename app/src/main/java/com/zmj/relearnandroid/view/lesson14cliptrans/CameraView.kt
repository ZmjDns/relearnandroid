package com.zmj.relearnandroid.view.lesson14cliptrans

import android.content.Context
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.zmj.relearnandroid.view.dp
import com.zmj.relearnandroid.view.getAvatar

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-12
 * Description :
 */
class CameraView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val BITMAP_SIZE = 200.dp
    private val BITMAP_PADDING = 100.dp
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(context!!,BITMAP_SIZE.toInt())

    private val cliped = Path().apply {
        addOval(BITMAP_PADDING,BITMAP_PADDING,BITMAP_PADDING+BITMAP_SIZE,BITMAP_PADDING+BITMAP_SIZE,Path.Direction.CCW)
    }

    private val camera = Camera().apply {
        rotateX(30f)
        setLocation(0f,0f,-6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
//        canvas.clipRect(BITMAP_PADDING,BITMAP_PADDING,BITMAP_PADDING+BITMAP_SIZE/2,BITMAP_PADDING+BITMAP_SIZE/2)
//        canvas.clipPath(cliped)

        canvas.save()
        canvas.translate((BITMAP_PADDING + BITMAP_SIZE/2), (BITMAP_PADDING + BITMAP_SIZE/2))
        canvas.rotate(-30f)
        canvas.clipRect(-BITMAP_SIZE, -BITMAP_SIZE,BITMAP_SIZE,0f)
        canvas.rotate(30f)
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE/2), -(BITMAP_PADDING + BITMAP_SIZE/2))
        canvas.drawBitmap(bitmap,BITMAP_PADDING,BITMAP_PADDING,paint)
        canvas.restore()


        //下半部分
        canvas.save()
        canvas.translate((BITMAP_PADDING+BITMAP_SIZE/2),(BITMAP_PADDING+BITMAP_SIZE/2))
        canvas.rotate(-30f)
        camera.applyToCanvas(canvas)
        canvas.clipRect(-BITMAP_SIZE,0f,BITMAP_SIZE,BITMAP_SIZE)
        canvas.rotate(30f)
        canvas.translate(-(BITMAP_PADDING+BITMAP_SIZE/2),-(BITMAP_PADDING+BITMAP_SIZE/2))
        canvas.drawBitmap(bitmap,BITMAP_PADDING,BITMAP_PADDING,paint)
        canvas.restore()
    }
}