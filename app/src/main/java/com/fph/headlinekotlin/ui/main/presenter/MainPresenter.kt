package com.fph.headlinekotlin.ui.main.presenter

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import com.feilu.kotlindemo.base.CommonSubscriber
import com.fph.headlinekotlin.hotfix.listener.MyPatchListener
import com.fph.headlinekotlin.hotfix.log.HotfixLogcat
import com.fph.headlinekotlin.ui.main.activity.MainActivity
import com.fph.headlinekotlin.ui.main.bean.Patch
import com.fph.headlinekotlin.ui.main.contract.MainContract
import com.fph.headlinekotlin.ui.main.model.MainModel
import com.fph.headlinekotlin.utils.AndroidUtils
import com.fph.headlinekotlin.utils.UpdateUtil
import com.tencent.tinker.lib.tinker.Tinker
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import java.io.File
import java.lang.ref.WeakReference
import java.util.*

/**
 * Created by fengpeihao on 2018/2/24.
 */
class MainPresenter : MainContract.Presenter, UpdateUtil.PatchCallback {
    constructor(view: MainActivity) : super() {
        setVM(view, MainModel())
    }

    private var mMyPatchListener: MyPatchListener? = null
    private var isLoaded: Boolean = false
    private var isInstalled: Boolean = false
    private var patchVersion: String = ""

    fun queryPatch() {
        isLoaded = Tinker.with(mView).isTinkerLoaded
        isInstalled = Tinker.isTinkerInstalled()
        val currentVersionName = AndroidUtils.getAppVersionName()
        val channel = AndroidUtils.getMarketId()
        if (isLoaded) {
            val loadResult = Tinker.with(mView).tinkerLoadResultIfPresent
            val config = loadResult.packageConfig
            patchVersion = config["patchVersion"].toString()
        }
        val queryParams = HashMap<String, String>()
        queryParams.put("channel", channel)
        queryParams.put("baseVersionName", currentVersionName)
        queryParams.put("clientType", "1")
        if (!TextUtils.isEmpty(patchVersion)) {
            queryParams.put("patchVersion", patchVersion)
        } else {
            queryParams.put("patchVersion", "")
        }
        mModel.getPatch(queryParams, object : CommonSubscriber<Patch>(mView) {
            override fun getData(patch: Patch) {
                if (patch != null && patch.data != null) {
                    if (currentVersionName == patch.data!!.baseVersionName && !TextUtils.isEmpty(patch.data!!.url)) {
                        //补丁版本要么等于空是首先安装补丁，要么补丁的版本有升级
                        if (isInstalled && TextUtils.isEmpty(patchVersion) || patchVersion != patch.data!!.patchVersion) {
                            //Log.v(MyPatchListener.TAG, "current version has new patch, current version is " +patchVersion +" new version is " + result.patchVersion);
                            HotfixLogcat.log("current version has new patch, current version is " + patchVersion + " new version is " + patch.data!!.patchVersion)
                            val thread = Thread(LoadFileTask(mView, patch, this@MainPresenter))
                            thread.start()
                        } else {
                            HotfixLogcat.log("current version has patch,but already fixed")
                            //Log.v(MyPatchListener.TAG, "current version has patch,but already fixed");
                            //Toast.makeText(context, "该版本下有补丁包，但是已修复补丁 ", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    HotfixLogcat.log("current version don't have patch")
                    //Log.v(MyPatchListener.TAG, "current version don't have patch");
                    //该版本下没有补丁包
                    //Toast.makeText(context, "该版本下没有补丁包 ", Toast.LENGTH_SHORT).show();
                }
            }

            override fun showExtraOp(message: String) {
                Toast.makeText(mView, message, Toast.LENGTH_SHORT).show()
            }

            override fun netError(message: String) {
                Toast.makeText(mView, message, Toast.LENGTH_SHORT).show()
            }
        }, mView)
    }

    fun getmMyPatchListener(): MyPatchListener? {
        return mMyPatchListener
    }

    internal class LoadFileTask(context: Context, private val result: Patch, private val callback: UpdateUtil.PatchCallback) : Runnable {
        private val weakReference: WeakReference<Context>

        init {
            weakReference = WeakReference(context)
        }

        override fun run() {
            val activity = weakReference.get() as RxAppCompatActivity?
            UpdateUtil.loadFile(activity, result.data?.url, result.data?.encryption, callback)
        }
    }

    override fun downloadSuccess(path: String) {
        val file = File(path)
        if (file.canRead()) {
            mMyPatchListener = MyPatchListener.getInstance(mView)
            mMyPatchListener?.path = path
            //            mMyPatchListener.initHotFixListener();
            mView.loadPatch()
        }
    }

    override fun downloadError(message: String) {

    }
}