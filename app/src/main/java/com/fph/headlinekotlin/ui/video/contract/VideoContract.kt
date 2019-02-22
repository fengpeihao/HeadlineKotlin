package com.fph.headlinekotlin.ui.video.contract

import com.feilu.kotlindemo.base.BaseModel
import com.feilu.kotlindemo.base.BasePresenter
import com.feilu.kotlindemo.base.BaseView
import com.feilu.kotlindemo.base.Common2Subscriber
import com.fph.headlinekotlin.ui.news.bean.NewsListBean
import com.fph.headlinekotlin.ui.video.bean.VideoListBean
import com.fph.headlinekotlin.ui.video.fragment.VideoFragment
import com.fph.headlinekotlin.ui.video.model.VideoModel

/**
 * Created by fengpeihao on 2018/1/22.
 */
interface VideoContract {
    interface View: BaseView{
        fun getVideoList(videoListBean: VideoListBean, loadType: Int)
    }

    interface Model: BaseModel {
        fun getVideoList(startKey: String?, newKey: String?,categoryId: String, count: Int, pgnum: Int, iswifi: String, position: String,subscriber: Common2Subscriber<VideoListBean>)

    }

    abstract class Presenter: BasePresenter<VideoFragment, VideoModel>(){
        abstract fun getVideoList(startKey: String?, newKey: String?,categoryId: String, count: Int, pgnum: Int, iswifi: String, position: String, loadType: Int)
    }
}