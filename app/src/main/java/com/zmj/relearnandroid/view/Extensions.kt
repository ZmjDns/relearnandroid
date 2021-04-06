package com.zmj.relearnandroid.view

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.TypedValue
import com.zmj.relearnandroid.R

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-03-27
 * Description :
 */
val Int.dp
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,this.toFloat(),Resources.getSystem().displayMetrics)

/**
 * 按照一定的比例去获取图片的Bitmap
 */
fun getAvatar(context: Context,width: Int): Bitmap {
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
//    BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.avatar_rengwuxian,options)
    BitmapFactory.decodeResource(context.resources,R.drawable.avatar_rengwuxian,options)
    options.inJustDecodeBounds = false
    options.inDensity = options.outWidth
    options.inTargetDensity = width
//    return BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.avatar_rengwuxian,options)
    return BitmapFactory.decodeResource(context.resources,R.drawable.avatar_rengwuxian,options)
}