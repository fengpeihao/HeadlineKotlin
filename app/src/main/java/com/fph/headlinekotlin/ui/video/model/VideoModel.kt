package com.fph.headlinekotlin.ui.video.model

import com.feilu.kotlindemo.api.Constant
import com.feilu.kotlindemo.base.Common2Subscriber
import com.feilu.kotlindemo.base.RxUtils
import com.fph.headlinekotlin.ui.news.bean.NewsListBean
import com.fph.headlinekotlin.ui.video.bean.VideoListBean
import com.fph.headlinekotlin.ui.video.contract.VideoContract

/**
 * Created by fengpeihao on 2018/1/22.
 */
class VideoModel : VideoContract.Model {
    override fun getVideoList(startKey: String?, newKey: String?,categoryId: String, count: Int, pgnum: Int, iswifi: String, position: String,subscriber: Common2Subscriber<VideoListBean>) {

        apiService.getVideoList(Constant.VIDEO_LIST,
                startKey?:"",
                newKey?:"",
                categoryId,
                count,
                pgnum,
                iswifi,
                position,
                "")
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(subscriber)
    }
}