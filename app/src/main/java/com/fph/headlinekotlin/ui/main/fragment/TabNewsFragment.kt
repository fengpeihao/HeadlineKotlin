package com.fph.headlinekotlin.ui.main.fragment

import android.os.Bundle
import com.feilu.kotlindemo.base.BaseFragment
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.ui.main.adapter.NewsNavigatorAdapter
import com.fph.headlinekotlin.ui.main.adapter.TabNewsAdapter
import com.fph.headlinekotlin.ui.main.bean.ChannelBean
import com.fph.headlinekotlin.ui.main.contract.TabNewsContract
import com.fph.headlinekotlin.ui.main.presenter.TabNewsPresenter
import com.fph.headlinekotlin.widget.magicindicator.ViewPagerHelper
import com.fph.headlinekotlin.widget.magicindicator.buildins.commonnavigator.CommonNavigator
import kotlinx.android.synthetic.main.fragment_tab_news.*


/**
 * Created by fengpeihao on 2018/1/10.
 */
class TabNewsFragment : BaseFragment(), TabNewsContract.View {

    private val mPresenter = TabNewsPresenter(this)
    private val mTitles = ArrayList<ChannelBean>()
    private var mAdapter : TabNewsAdapter?=null

    override fun getLayoutId(): Int {
        return R.layout.fragment_tab_news
    }

    override fun init(savedInstanceState: Bundle?) {
        mPresenter.getTitles()
        magic_indicator.navigator = getCommonNavigator()
        ViewPagerHelper.bind(magic_indicator, view_pager)
        mAdapter = TabNewsAdapter(fragmentManager, mTitles)
        view_pager.adapter = mAdapter
    }

    private fun getCommonNavigator(): CommonNavigator {
        val commonNavigator = CommonNavigator(context)
        commonNavigator.scrollPivotX = 0.65f
        commonNavigator.isAdjustMode = false
        commonNavigator.adapter = NewsNavigatorAdapter(mTitles, view_pager)
        return commonNavigator
    }

    override fun getTitles(titles: ArrayList<ChannelBean>) {
        mTitles.clear();
        mTitles.addAll(titles)
        mAdapter?.notifyDataSetChanged()
        magic_indicator.navigator.notifyDataSetChanged()
    }
}