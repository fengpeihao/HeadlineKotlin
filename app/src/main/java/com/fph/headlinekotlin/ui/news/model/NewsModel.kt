package com.fph.headlinekotlin.ui.news.model

import com.feilu.kotlindemo.api.Constant
import com.feilu.kotlindemo.base.Common2Subscriber
import com.feilu.kotlindemo.base.RxUtils
import com.fph.headlinekotlin.ui.news.bean.NewsListBean
import com.fph.headlinekotlin.ui.news.contract.NewsContract
import com.fph.headlinekotlin.utils.AndroidUtils
import com.fph.headlinekotlin.utils.CloudManager

/**
 * Created by fengpeihao on 2018/1/22.
 */
class NewsModel : NewsContract.Model {
    override fun getNewsList(startKey: String?, newKey: String?, pgnum: Int, idx: Int, type: String, position: String,subscriber: Common2Subscriber<NewsListBean>) {

        apiService.getNewsList(Constant.NEWS_LIST,
                startKey?:"",
                newKey?:"",
                pgnum,
                idx,
                type,
                AndroidUtils.getIme(),
                CloudManager.cloudKeyFromLocal,
                "DFTT",
                "010907",
                position,
                "")
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(subscriber)
    }
}