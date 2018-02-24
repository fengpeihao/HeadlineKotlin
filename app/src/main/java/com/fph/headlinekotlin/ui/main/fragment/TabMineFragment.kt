package com.fph.headlinekotlin.ui.main.fragment

import android.os.Bundle
import com.feilu.kotlindemo.base.BaseFragment
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.ui.usercenter.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_tab_mine.*

/**
 * Created by fengpeihao on 2018/1/11.
 */
class TabMineFragment :BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_tab_mine
    }

    override fun init(savedInstanceState: Bundle?) {
        tv_mine.setOnClickListener{startActivity(LoginActivity::class.java)}
    }
}