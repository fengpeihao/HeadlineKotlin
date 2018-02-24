package com.fph.headlinekotlin.ui.main.activity

import com.feilu.kotlindemo.base.BaseActivity
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.utils.CloudManager

class SplashActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun init() {
        CloudManager.fetchCloudKey()
    }
}
