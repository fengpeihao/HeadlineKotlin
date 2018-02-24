package com.fph.headlinekotlin.ui.news.contract

import com.feilu.kotlindemo.base.BaseModel
import com.feilu.kotlindemo.base.BasePresenter
import com.feilu.kotlindemo.base.BaseView
import com.feilu.kotlindemo.base.Common2Subscriber
import com.fph.headlinekotlin.ui.news.bean.NewsListBean
import com.fph.headlinekotlin.ui.news.fragment.NewsFragment
import com.fph.headlinekotlin.ui.news.model.NewsModel

/**
 * Created by fengpeihao on 2018/1/22.
 */
interface NewsContract {
    interface View: BaseView{
        fun getNewsList(newsListBean: NewsListBean, loadType: Int)
    }

    interface Model: BaseModel {
        fun getNewsList(startKey: String?, newKey: String?, pgnum: Int, idx: Int, type: String, position: String,subscriber: Common2Subscriber<NewsListBean>)

    }

    abstract class Presenter: BasePresenter<NewsFragment,NewsModel>(){
        abstract fun getNewsList(startKey: String?, newKey: String?, pgnum: Int, idx: Int, type: String, position: String, loadType: Int)
    }
}