package com.fph.headlinekotlin.ui.main.model

import com.feilu.kotlindemo.base.BaseActivity
import com.feilu.kotlindemo.base.CommonSubscriber
import com.feilu.kotlindemo.base.RxUtils
import com.fph.headlinekotlin.api.ApiModule
import com.fph.headlinekotlin.ui.main.bean.Patch
import com.fph.headlinekotlin.ui.main.contract.MainContract

/**
 * Created by fengpeihao on 2018/2/24.
 */
class MainModel : MainContract.Model{

    private val htmlApiService = ApiModule.provideHtmlApiService()

    fun getPatch(maps: Map<String, String>, commonSubscriber: CommonSubscriber<Patch>,context: BaseActivity) {
        val channel = maps["channel"]
        val baseVersionName = maps["baseVersionName"]
        val clientType = maps["clientType"]
        val patchVersion = maps["patchVersion"]
        apiService.queryPatch(channel!!, baseVersionName!!, clientType!!, patchVersion!!)
                .compose(RxUtils.rxSchedulerHelper(context))
                .subscribeWith(commonSubscriber)
    }
}