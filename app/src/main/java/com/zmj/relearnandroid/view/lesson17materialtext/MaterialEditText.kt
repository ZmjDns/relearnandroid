package com.zmj.relearnandroid.view.lesson17materialtext

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import com.zmj.relearnandroid.view.dp

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-21
 * Description :
 */

private val TEXT_SIZE = 12.dp
private val TEXT_MARGIN = 8.dp

private val HORIZONTAL_OFFSET = 5.dp
private val VERTICAL_OFFSET = 23.dp
private val EXTRA_VERTICAL_OFFSET = 16.dp

class MaterialEditText(context: Context, attrs: AttributeSet?) : AppCompatEditText(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var floatingLabelShown = false
    var floatingLabelFraction = 0f
        set(value) {
            field = value
            invalidate()
        }

    init {
        paint.textSize = TEXT_SIZE
        setPadding(paddingLeft,(paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(),paddingRight,paddingBottom)
    }
    private val animator by lazy {
        ObjectAnimator.ofFloat(this,"floatingLabelFraction",0f,1f)
    }

    override fun onTextChanged(text: CharSequence?,start: Int,lengthBefore: Int,lengthAfter: Int) {
        if (floatingLabelShown && text.isNullOrEmpty()) {   //输入从有到无
            floatingLabelShown = false
            animator.reverse()
        } else if (!floatingLabelShown && !text.isNullOrEmpty()) {  // 输入从无到有
            floatingLabelShown = true
            animator.start()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.alpha = (floatingLabelFraction * 0xff).toInt()
        val currentVerticalValue = VERTICAL_OFFSET + EXTRA_VERTICAL_OFFSET * (1 - floatingLabelFraction)
        canvas.drawText(hint.toString(), HORIZONTAL_OFFSET, currentVerticalValue,paint)
    }

}