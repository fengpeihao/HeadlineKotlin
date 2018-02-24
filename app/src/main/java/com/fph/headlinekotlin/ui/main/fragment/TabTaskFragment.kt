package com.fph.headlinekotlin.ui.main.fragment

import android.os.Bundle
import com.feilu.kotlindemo.base.BaseFragment
import com.fph.headlinekotlin.R
import kotlinx.android.synthetic.main.fragment_tab_task.*

/**
 * Created by fengpeihao on 2018/1/11.
 */
class TabTaskFragment :BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_tab_task
    }

    override fun init(savedInstanceState: Bundle?) {
        tv_task.setOnClickListener {

        }
    }
}