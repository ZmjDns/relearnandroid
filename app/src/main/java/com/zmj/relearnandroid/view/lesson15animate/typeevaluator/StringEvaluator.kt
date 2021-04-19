package com.zmj.relearnandroid.view.lesson15animate.typeevaluator

import android.animation.TypeEvaluator

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2021-04-19
 * Description :
 */
class StringEvaluator: TypeEvaluator<String> {
    private val provinceList = arrayListOf(
        "北京市",
        "天津市",
        "河北省",
        "山西省",
        "内蒙古自治区",
        "辽宁省",
        "吉林省",
        "黑龙江省",
        "上海市",
        "江苏省",
        "浙江省",
        "安徽省",
        "福建省",
        "江西省",
        "山东省"
    )

    override fun evaluate(fraction: Float, startValue: String, endValue: String): String {
        val startIndex = provinceList.indexOf(startValue)
        val endIndex = provinceList.indexOf(endValue)
        val currentIndex = startIndex + ((endIndex - startIndex) * fraction).toInt()
        return provinceList[currentIndex]
    }
}