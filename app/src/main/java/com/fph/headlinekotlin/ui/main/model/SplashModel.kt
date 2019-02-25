package com.fph.headlinekotlin.ui.main.model

import com.feilu.kotlindemo.base.BaseActivity
import com.feilu.kotlindemo.base.Common2Subscriber
import com.feilu.kotlindemo.base.CommonSubscriber
import com.feilu.kotlindemo.base.RxUtils
import com.fph.headlinekotlin.api.ApiModule
import com.fph.headlinekotlin.ui.main.bean.CssListBean
import com.fph.headlinekotlin.ui.main.bean.Patch
import com.fph.headlinekotlin.ui.main.contract.SplashContract
import io.reactivex.ObservableSource
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * Created by fengpeihao on 2018/2/24.
 */
class SplashModel : SplashContract.Model {

    private val htmlApiService = ApiModule.provideHtmlApiService()

    fun getPatch(maps: Map<String, String>, commonSubscriber: CommonSubscriber<Patch>, context: BaseActivity) {
        val channel = maps["channel"]
        val baseVersionName = maps["baseVersionName"]
        val clientType = maps["clientType"]
        val patchVersion = maps["patchVersion"]
        apiService.queryPatch(channel!!, baseVersionName!!, clientType!!, patchVersion!!)
                .compose(RxUtils.rxSchedulerHelper(context))
                .subscribeWith(commonSubscriber)
    }

    override fun getCssList(subscriber: Common2Subscriber<CssListBean>, context: BaseActivity) {
        val url = "https://detailstyle.dftoutiao.com/app/allcss"
        apiService.getCssList(url, "")
                .compose(RxUtils.rxSchedulerHelper(context))
                .subscribeWith(subscriber)
    }

    override fun getHtmlContent(url: String, subscriber: Common2Subscriber<String>) {
        htmlApiService.getHtmlContent(url)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(subscriber)
    }
}