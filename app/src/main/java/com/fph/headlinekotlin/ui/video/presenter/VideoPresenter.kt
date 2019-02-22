package com.fph.headlinekotlin.ui.video.presenter

import com.feilu.kotlindemo.base.Common2Subscriber
import com.fph.headlinekotlin.ui.news.bean.NewsListBean
import com.fph.headlinekotlin.ui.video.bean.VideoListBean
import com.fph.headlinekotlin.ui.video.contract.VideoContract
import com.fph.headlinekotlin.ui.video.fragment.VideoFragment
import com.fph.headlinekotlin.ui.video.model.VideoModel

/**
 * Created by fengpeihao on 2018/1/22.
 */
class VideoPresenter : VideoContract.Presenter {
    constructor(view: VideoFragment) : super() {
        setVM(view, VideoModel())
    }

    override fun getVideoList(startKey: String?, newKey: String?, categoryId: String, count: Int, pgnum: Int, iswifi: String, position: String, loadType: Int) {
        mModel.getVideoList(startKey, newKey, categoryId, count, pgnum, position, iswifi, object : Common2Subscriber<VideoListBean>() {
            override fun netError(message: String) {
                mView.showToast(message)
            }

            override fun getData(t: VideoListBean) {
                mView.getVideoList(t, loadType)
            }
        })
    }
}