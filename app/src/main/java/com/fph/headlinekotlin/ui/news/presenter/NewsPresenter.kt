package com.fph.headlinekotlin.ui.news.presenter

import com.feilu.kotlindemo.base.Common2Subscriber
import com.fph.headlinekotlin.ui.news.bean.NewsListBean
import com.fph.headlinekotlin.ui.news.contract.NewsContract
import com.fph.headlinekotlin.ui.news.fragment.NewsFragment
import com.fph.headlinekotlin.ui.news.model.NewsModel

/**
 * Created by fengpeihao on 2018/1/22.
 */
class NewsPresenter : NewsContract.Presenter {
    constructor(view: NewsFragment) : super() {
        setVM(view, NewsModel())
    }

    override fun getNewsList(startKey: String?, newKey: String?, pgnum: Int, idx: Int, type: String, position: String, loadType: Int) {
        mModel.getNewsList(startKey, newKey, pgnum, idx, type, position, object : Common2Subscriber<NewsListBean>() {
            override fun netError(message: String) {
                mView.showToast(message)
            }

            override fun getData(t: NewsListBean) {
                mView.getNewsList(t, loadType)
            }
        })
    }
}