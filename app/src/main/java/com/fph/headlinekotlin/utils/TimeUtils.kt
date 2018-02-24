package com.fph.headlinekotlin.utils

import android.text.TextUtils
import java.text.SimpleDateFormat

/**
 * Created by fengpeihao on 2018/2/22.
 */
object TimeUtils {

    val format: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")

    fun getNewsTime(date: String): String {
        if(TextUtils.isEmpty(date)){
            return "1分钟前"
        }
        val newsTime = format.parse(date).time
        val currentTime = System.currentTimeMillis()
        var difTime = currentTime - newsTime
        var time = difTime / 1000 * 60
        if (time > 0) {
            if (time / 60 > 0) {
                return (time / 60).toString() + "小时前"
            }
            return time.toString() + "分钟前"
        } else {
            return "1分钟前"
        }
    }
}