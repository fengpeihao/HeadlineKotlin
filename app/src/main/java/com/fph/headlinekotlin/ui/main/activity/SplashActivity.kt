package com.fph.headlinekotlin.ui.main.activity

import android.os.Handler
import android.view.WindowManager
import com.feilu.kotlindemo.api.Constant
import com.feilu.kotlindemo.base.BaseActivity
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.ui.main.contract.SplashContract
import com.fph.headlinekotlin.ui.main.presenter.SplashPresenter
import com.fph.headlinekotlin.utils.CacheUtils
import com.fph.headlinekotlin.utils.CloudManager

class SplashActivity : BaseActivity(), SplashContract.View {

    private val mPresenter = SplashPresenter(this)
    private val mHandle = Handler()
    private val mRunnable = Runnable { skipMain() }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun init() {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        CloudManager.fetchCloudKey()
        mHandle.postDelayed(mRunnable, 2000)
        if (CacheUtils.getBoolean(Constant.isFirstStart, true)) {
            mPresenter.getCssList()
        }
    }

    private fun skipMain() {
        startActivity(MainActivity::class.java)
        finish()
    }

    override fun onDestroy() {
        mHandle.removeCallbacks(mRunnable)
        super.onDestroy()
    }
}
