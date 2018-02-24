package com.feilu.kotlindemo.base

import android.content.Context
import android.content.Intent
import com.feilu.kotlindemo.api.Constant
import com.fph.headlinekotlin.base.App
import com.fph.headlinekotlin.base.BaseEntity
import com.fph.headlinekotlin.ui.usercenter.activity.LoginActivity
import com.fph.headlinekotlin.utils.AccountUtils
import com.fph.headlinekotlin.utils.AndroidUtils
import io.reactivex.subscribers.ResourceSubscriber

/**
 * Created by fengpeihao on 2017/11/11.
 */
abstract class CommonSubscriber<T : BaseEntity> : ResourceSubscriber<T> {

    private var isShowLoading = true
    private var isCancelLoading = true
    private var mContext: Context? = null

    constructor(context: Context) : super() {
        mContext = context
    }

    constructor(context: Context, isShowLoading: Boolean) {
        mContext = context
        this.isShowLoading = isShowLoading;
    }

    constructor(context: Context, isShowLoading: Boolean, isCancelLoading: Boolean) {
        mContext = context
        this.isShowLoading = isShowLoading;
        this.isCancelLoading = isCancelLoading
    }

    override fun onStart() {
        if (isShowLoading && mContext != null) {
            AndroidUtils.showLoading(mContext!!)
        }
        super.onStart()
    }

    override fun onNext(t: T) {
        if (Constant.successCode.equals(t.code)) {
            if (isCancelLoading) {
                AndroidUtils.cancelLoading()
            }
            getData(t)
        } else if (Constant.tokenLossed.equals(t.code) || Constant.tokenNoFit.equals(t.code)) {
            AndroidUtils.cancelLoading()
            val intent = Intent(App.context, LoginActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            AccountUtils.clearAccountInfo()
            App.context.startActivity(intent)
        } else {
            AndroidUtils.cancelLoading()
            showExtraOp(t.message!!)
        }
    }

    override fun onComplete() {

    }

    override fun onError(e: Throwable) {
        AndroidUtils.cancelLoading()
        netError("网络异常")
    }

    abstract fun netError(message: String)

    abstract fun showExtraOp(message: String)

    abstract fun getData(t: T)
}