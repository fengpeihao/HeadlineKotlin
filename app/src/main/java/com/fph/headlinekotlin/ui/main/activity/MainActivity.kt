package com.fph.headlinekotlin.ui.main.activity

import android.support.v4.app.Fragment
import com.feilu.kotlindemo.api.Constant
import com.feilu.kotlindemo.base.BaseActivity
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.ui.main.contract.MainContract
import com.fph.headlinekotlin.ui.main.fragment.TabMineFragment
import com.fph.headlinekotlin.ui.main.fragment.TabNewsFragment
import com.fph.headlinekotlin.ui.main.fragment.TabTaskFragment
import com.fph.headlinekotlin.ui.main.fragment.TabVideoFragment
import com.fph.headlinekotlin.ui.main.presenter.MainPresenter
import com.fph.headlinekotlin.ui.main.widget.BottomTabView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View {

    private val mFragments = ArrayList<Fragment>()
    private var mCurrentIndex: Int = BottomTabView.NEWS
    private val mPresenter = MainPresenter(this)

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        initFragment()
        mCurrentIndex = intent.extras?.getInt(Constant.defaultIndex, BottomTabView.NEWS) ?: BottomTabView.NEWS
        showFragment(mCurrentIndex)
        bottom_tab_view.setDefaultChcekIndex(mCurrentIndex)
        initListener()
    }

    private fun initListener() {
        bottom_tab_view.mListener = object : BottomTabView.OnTabCheckedListener {
            override fun onTanCheckedChange(index: Int) {
                showFragment(index)
            }
        }
    }

    private fun initFragment() {
        val newsFragment: Fragment = TabNewsFragment()
        val videoFragment: Fragment = TabVideoFragment()
        val taskFragment: Fragment = TabTaskFragment()
        val mineFragment: Fragment = TabMineFragment()
        mFragments.add(newsFragment)
        mFragments.add(videoFragment)
        mFragments.add(taskFragment)
        mFragments.add(mineFragment)
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.frame_layout, newsFragment)
                .add(R.id.frame_layout, videoFragment)
                .add(R.id.frame_layout, taskFragment)
                .add(R.id.frame_layout, mineFragment)
                .hide(newsFragment)
                .hide(videoFragment)
                .hide(taskFragment)
                .hide(mineFragment)
                .commit()
    }

    private fun showFragment(index: Int) {
        val ft = supportFragmentManager.beginTransaction()
        for (i in mFragments.indices) {
            if (index == i) {
                ft.show(mFragments[i])
            } else {
                ft.hide(mFragments[i])
            }
        }
        ft.commit()
    }

    fun loadPatch() {
        val mMyPatchListener = mPresenter.getmMyPatchListener()
        if (mMyPatchListener != null && !mMyPatchListener.isPatching()) {
            mMyPatchListener.patching()
        }
    }
}
