package com.fph.headlinekotlin.ui.main.presenter

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import com.feilu.kotlindemo.base.Common2Subscriber
import com.feilu.kotlindemo.base.CommonSubscriber
import com.fph.headlinekotlin.hotfix.listener.MyPatchListener
import com.fph.headlinekotlin.hotfix.log.HotfixLogcat
import com.fph.headlinekotlin.ui.main.activity.MainActivity
import com.fph.headlinekotlin.ui.main.bean.CssListBean
import com.fph.headlinekotlin.ui.main.bean.Patch
import com.fph.headlinekotlin.ui.main.contract.MainContract
import com.fph.headlinekotlin.ui.main.model.MainModel
import com.fph.headlinekotlin.utils.AndroidUtils
import com.fph.headlinekotlin.utils.UpdateUtil
import com.tencent.tinker.lib.tinker.Tinker
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import java.io.File
import java.lang.ref.WeakReference
import java.util.*
import android.R.attr.tag
import android.R.attr.tag
import android.util.Log
import com.feilu.kotlindemo.base.RxUtils
import com.fph.headlinekotlin.ui.main.activity.SplashActivity
import com.fph.headlinekotlin.ui.main.contract.SplashContract
import com.fph.headlinekotlin.ui.main.model.SplashModel
import com.fph.headlinekotlin.utils.FileUtils
import io.reactivex.functions.Function


/**
 * Created by fengpeihao on 2018/2/24.
 */
class SplashPresenter : SplashContract.Presenter{
    constructor(view: SplashActivity) : super() {
        setVM(view, SplashModel())
    }

    override fun getCssList() {
        mModel.getCssList(object : Common2Subscriber<CssListBean>() {
            override fun netError(message: String) {

            }

            override fun getData(t: CssListBean) {
                for (item in t.data) {
                    getHtmlContent(item)
                }
            }
        }, mView)
    }

    override fun getHtmlContent(url: String) {
        mModel.getHtmlContent(url, object : Common2Subscriber<String>() {
            override fun getData(t: String) {
                Flowable.just(FileUtils.saveFile(mView, FileUtils.getCssFileNameFromUrl(url), t))
                        .compose(RxUtils.rxSchedulerHelper())
                        .subscribe()
            }

            override fun netError(message: String) {
                Log.e("netError",message)
            }
        })
    }
}