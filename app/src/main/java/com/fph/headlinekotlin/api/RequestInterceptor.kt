package com.feilu.kotlindemo.api

import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.base.App
import com.fph.headlinekotlin.utils.AccountUtils
import com.fph.headlinekotlin.utils.AndroidUtils
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

/**
 * Created by fengpeihao on 2017/11/14.
 */
class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain!!.request()
        val newBuilder = request.newBuilder()

        val headerBuilder = request.headers().newBuilder()
        val map_head = HashMap<String, String>()
        map_head.put("serial-number", AndroidUtils.getRequestId())
        map_head.put("request-time", AndroidUtils.getSystemTime())
        map_head.put("device-id", AndroidUtils.getIme())
        map_head.put("os", "android")
        map_head.put("app-id", "3676550554163200")
        map_head.put("app-version", AndroidUtils.getAppVersionName())
        map_head.put("market", AndroidUtils.getMarketId())
        map_head.put("app-stage", App.context.getResources().getString(R.string.app_stage))
        map_head.put("customer-id", AccountUtils.customerId)
        map_head.put("access-token", AccountUtils.accessToken)
        map_head.put("os-version", AndroidUtils.getAndroidSDKVersion())
        map_head.put("phone-models", AndroidUtils.getSystemModel())
        map_head.put("sign", AndroidUtils.getSign(map_head, "123"))

        for (key in map_head.keys) {
            headerBuilder.add(key, map_head.get(key))
        }

        newBuilder.headers(headerBuilder.build())
        return chain.proceed(newBuilder.build())
    }
}