package com.fph.headlinekotlin.ui.main.contract

import com.feilu.kotlindemo.base.*
import com.fph.headlinekotlin.ui.main.activity.SplashActivity
import com.fph.headlinekotlin.ui.main.bean.CssListBean
import com.fph.headlinekotlin.ui.main.model.SplashModel

/**
 * Created by fengpeihao on 2018/2/24.
 */
interface SplashContract {
    interface View : BaseView {

    }

    interface Model : BaseModel {
        fun getCssList(commonSubscriber: Common2Subscriber<CssListBean>, context: BaseActivity)
        fun getHtmlContent(url: String, subscriber: Common2Subscriber<String>)
    }

    abstract class Presenter : BasePresenter<SplashActivity, SplashModel>() {
        abstract fun getCssList()

        abstract fun getHtmlContent(url: String)
    }
}