package com.fph.headlinekotlin.ui.main.presenter

import com.feilu.kotlindemo.base.Common2Subscriber
import com.fph.headlinekotlin.ui.main.activity.WebViewActivity
import com.fph.headlinekotlin.ui.main.contract.WebViewContract
import com.fph.headlinekotlin.ui.main.model.WebViewModel
import com.fph.headlinekotlin.utils.NewsHtmlUtils

/**
 * Created by fengpeihao on 2018/3/20.
 */
class WebViewPresenter : WebViewContract.Presenter {
    constructor(view: WebViewActivity) : super() {
        setVM(view, WebViewModel())
    }

    override fun getHtmlContent(url: String) {
        mModel.getHtmlContent(url, object : Common2Subscriber<String>() {
            override fun netError(message: String) {
                mView.getHtmlContentFail()
            }

            override fun getData(t: String) {
                val htmlContent = NewsHtmlUtils.getHtmlContent(t)
                mView.getHtmlContentSuccess(htmlContent)
            }
        })
    }
}