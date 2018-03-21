package com.fph.headlinekotlin.ui.main.contract

import com.feilu.kotlindemo.base.BaseModel
import com.feilu.kotlindemo.base.BasePresenter
import com.feilu.kotlindemo.base.BaseView
import com.feilu.kotlindemo.base.Common2Subscriber
import com.fph.headlinekotlin.ui.main.activity.WebViewActivity
import com.fph.headlinekotlin.ui.main.model.WebViewModel

/**
 * Created by fengpeihao on 2018/3/20.
 */

interface WebViewContract {
    interface View : BaseView {
        fun getHtmlContentFail()

        fun getHtmlContentSuccess(content: String)
    }

    interface Model : BaseModel {
        fun getHtmlContent(url: String, subscriber: Common2Subscriber<String>);
    }

    public abstract class Presenter : BasePresenter<WebViewActivity, WebViewModel>() {
        abstract fun getHtmlContent(url: String)
    }
}
