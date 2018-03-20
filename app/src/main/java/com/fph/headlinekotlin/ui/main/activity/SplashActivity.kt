package com.fph.headlinekotlin.ui.main.activity

import android.os.Handler
import android.view.WindowManager
import com.feilu.kotlindemo.base.BaseActivity
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.utils.CloudManager

class SplashActivity : BaseActivity() {

    private val mHandle = Handler()
    private val mRunnable = Runnable { skipMain() }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun init() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        CloudManager.fetchCloudKey()
        mHandle.postDelayed(mRunnable, 2000)
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
