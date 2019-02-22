package com.fph.headlinekotlin.utils

import android.text.TextUtils
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by fengpeihao on 2018/2/22.
 */
object TimeUtils {

    val format: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")

    fun getNewsTime(date: String): String {
        if (TextUtils.isEmpty(date)) {
            return "1分钟前"
        }
        val newsTime = format.parse(date).time
        val currentTime = System.currentTimeMillis() / 1000
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

    fun getVideoTime(time: String?): String {
        val timeMs = time?.toLong() ?: 0L
        if (timeMs <= 0 || timeMs >= 24 * 60 * 60 * 1000) {
            return "00:00"
        }
        val totalSeconds = (timeMs / 1000).toInt()
        val seconds = totalSeconds % 60
        val minutes = totalSeconds / 60 % 60
        val hours = totalSeconds / 3600
        val stringBuilder = StringBuilder()
        val mFormatter = Formatter(stringBuilder, Locale.getDefault())
        return if (hours > 0) {
            mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString()
        } else {
            mFormatter.format("%02d:%02d", minutes, seconds).toString()
        }
    }
}