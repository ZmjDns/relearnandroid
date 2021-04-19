package com.zmj.relearnandroid.view.lesson15animate

import android.animation.AnimatorSet
import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zmj.relearnandroid.R
import com.zmj.relearnandroid.view.dp
import com.zmj.relearnandroid.view.lesson15animate.typeevaluator.PointFEvaluator
import kotlinx.android.synthetic.main.act_animate.*

class AnimateAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_animate)

//        avator.animate()
//            .translationX(100.dp).startDelay = 1000

//        circleViewAnim()

//        flipAnimate()

//        valuesHolder()

//        keyFrameAnim()

//        circleViewKeyFrame()

        typeEvaluator()

    }

    private fun circleViewAnim(){
//        val objAnimate = ObjectAnimator.ofFloat(circleView,"radius",100.dp)
        val objAnimate = ObjectAnimator.ofFloat(circleView,"sweepAngle", 0f,360f,720f,1080f)
        objAnimate.startDelay = 1000
        objAnimate.duration = 5000
        objAnimate.start()
    }

    private fun circleViewKeyFrame() {
        val degree = 1080f
        val keyframe0 = Keyframe.ofFloat(0f, 0f * degree)
        val keyframe1 = Keyframe.ofFloat(0.25f,0.25f * degree)
        val keyframe2 = Keyframe.ofFloat(0.6f, 0.6f * degree)
        val keyframe3 = Keyframe.ofFloat(1f, 1f * degree)

        val keyFrameHolder = PropertyValuesHolder.ofKeyframe("sweepAngle",keyframe0,keyframe1,keyframe2,keyframe3)
        val keyObj = ObjectAnimator.ofPropertyValuesHolder(circleView,keyFrameHolder)
        keyObj.startDelay = 1000
        keyObj.duration = 5000
        keyObj.start()
    }

    private fun flipAnimate() {

        val xAlixObj = ObjectAnimator.ofFloat(flipView,"bottomFlip",60f)
        xAlixObj.startDelay = 1000
        xAlixObj.setDuration(1000)
//            .start()

        val objectAnimator = ObjectAnimator.ofFloat(flipView,"flipAngle",270f)
        objectAnimator.startDelay = 200
        objectAnimator
            .setDuration(1000)
//            .start()

        val topObj = ObjectAnimator.ofFloat(flipView,"topFlip",-60f)
        topObj.startDelay = 200
        topObj.setDuration(1000)
//            .start()




        val animSet = AnimatorSet()
        animSet.playSequentially(xAlixObj,objectAnimator,topObj)
        animSet.start()
    }

    //同一个动画操作多个属性
    private fun valuesHolder() {
        val bottomFlipHolder = PropertyValuesHolder.ofFloat("bottomFlip",60f)
        val rotateHolder = PropertyValuesHolder.ofFloat("flipAngle", 270f)
        val topFlipHolder = PropertyValuesHolder.ofFloat("topFlip", -60f)

        val holderAnimator = ObjectAnimator.ofPropertyValuesHolder(flipView,bottomFlipHolder,rotateHolder,topFlipHolder)

        holderAnimator.startDelay = 1000
        holderAnimator.duration = 3000
        holderAnimator.start()
    }

    private fun keyFrameAnim() {
        val length = 200.dp
        val keyframe0 = Keyframe.ofFloat(0f, 0f)
        val keyframe1 = Keyframe.ofFloat(0.2f,0.4f * length)
        val keyframe2 = Keyframe.ofFloat(0.8f,0.6f * length)
        val keyframe3 = Keyframe.ofFloat(1f,1f*length)

        val keyFrameHolder = PropertyValuesHolder.ofKeyframe("translationX", keyframe0,keyframe1,keyframe2,keyframe3)
        val animator = ObjectAnimator.ofPropertyValuesHolder(flipView,keyFrameHolder)
        animator.startDelay = 1000
        animator.duration = 2000
        animator.start()
    }

    private fun typeEvaluator() {
        val objectAnim = ObjectAnimator.ofObject(point,"point",PointFEvaluator(),PointF(200.dp,100.dp))

        objectAnim.duration = 2000
        objectAnim.startDelay = 1000
        objectAnim.start()
    }
}