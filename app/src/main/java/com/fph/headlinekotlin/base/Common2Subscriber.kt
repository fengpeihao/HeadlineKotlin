package com.feilu.kotlindemo.base

import android.content.Context
import com.fph.headlinekotlin.utils.AndroidUtils
import io.reactivex.subscribers.ResourceSubscriber

/**
 * Created by fengpeihao on 2017/11/11.
 */
abstract class Common2Subscriber<T> : ResourceSubscriber<T> {

    private var isShowLoading = true
    private var isCancelLoading = true
    private var mContext: Context? = null

    constructor() : super()

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
        if (isCancelLoading) {
            AndroidUtils.cancelLoading()
        }
        getData(t)
    }

    override fun onComplete() {

    }

    override fun onError(e: Throwable) {
        AndroidUtils.cancelLoading()
        netError("网络异常")
    }

    abstract fun netError(message: String)

    abstract fun getData(t: T)
}