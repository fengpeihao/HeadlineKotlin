package com.fph.headlinekotlin.ui.main.model

import com.feilu.kotlindemo.base.Common2Subscriber
import com.feilu.kotlindemo.base.RxUtils
import com.fph.headlinekotlin.api.ApiModule
import com.fph.headlinekotlin.ui.main.contract.WebViewContract

/**
 * Created by fengpeihao on 2018/3/20.
 */
class WebViewModel : WebViewContract.Model {
    override fun getHtmlContent(url: String, subscriber: Common2Subscriber<String>) {
        ApiModule.provideHtmlApiService().getHtmlContent(url).compose(RxUtils.rxSchedulerHelper()).subscribeWith(subscriber)
    }
}