package com.zmj.relearnandroid.view.lesson15animate

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zmj.relearnandroid.R
import com.zmj.relearnandroid.view.dp
import kotlinx.android.synthetic.main.act_animate.*

class AnimateAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_animate)

//        avator.animate()
//            .translationX(100.dp).startDelay = 1000

//        circleViewAnim()

        flipAnimate()
    }

    private fun circleViewAnim(){
//        val objAnimate = ObjectAnimator.ofFloat(circleView,"radius",100.dp)
        val objAnimate = ObjectAnimator.ofFloat(circleView,"sweepAngle", 0f,360f,720f,1080f)
        objAnimate.startDelay = 1000
        objAnimate.duration = 5000
        objAnimate.start()
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
}