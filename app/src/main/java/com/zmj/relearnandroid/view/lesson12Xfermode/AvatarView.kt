package com.zmj.relearnandroid.view.lesson12Xfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.zmj.relearnandroid.view.dp
import com.zmj.relearnandroid.view.getAvatar

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-06
 * Description :
 */
class AvatarView(context: Context, attrs: AttributeSet): View(context, attrs) {

    private val IMAGE_PADDING = 20.dp
    private val IMAGE_WIDTH = 200.dp
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap = getAvatar(context,IMAGE_WIDTH.toInt())
    private val xFermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    private val bounds = RectF(IMAGE_PADDING,IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH)


    override fun onDraw(canvas: Canvas) {

        canvas.drawOval(IMAGE_PADDING/2,IMAGE_PADDING/2,IMAGE_PADDING * 1.5f + IMAGE_WIDTH, IMAGE_PADDING * 1.5f + IMAGE_WIDTH,paint)

        val count =  canvas.saveLayer(bounds,null)   //离屏缓冲，否则无法画出圆形头像
        canvas.drawOval(IMAGE_PADDING,IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH,paint)
        paint.xfermode = xFermode
        canvas.drawBitmap(bitmap,IMAGE_PADDING,IMAGE_PADDING,paint)
        paint.xfermode = null
        canvas.restoreToCount(count)    //恢复离屏缓冲
    }
}