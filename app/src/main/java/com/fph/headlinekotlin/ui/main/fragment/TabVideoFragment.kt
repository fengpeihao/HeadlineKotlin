package com.fph.headlinekotlin.ui.main.fragment

import android.os.Bundle
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.base.LazyFragment
import com.fph.headlinekotlin.ui.main.adapter.NewsNavigatorAdapter
import com.fph.headlinekotlin.ui.main.adapter.TabVideoAdapter
import com.fph.headlinekotlin.ui.main.bean.ChannelBean
import com.fph.headlinekotlin.ui.main.contract.TabVideoContract
import com.fph.headlinekotlin.ui.main.presenter.TabVideoPresenter
import com.fph.headlinekotlin.widget.magicindicator.ViewPagerHelper
import com.fph.headlinekotlin.widget.magicindicator.buildins.commonnavigator.CommonNavigator
import kotlinx.android.synthetic.main.fragment_tab_video.*

/**
 * Created by fengpeihao on 2018/1/11.
 */
class TabVideoFragment : LazyFragment(), TabVideoContract.View {

    private val mPresenter = TabVideoPresenter(this)
    private val mTitles = ArrayList<ChannelBean>()
    private var mAdapter: TabVideoAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_tab_video
    }

    override fun lazyInit() {
        mPresenter.getTitles()
    }

    override fun init(savedInstanceState: Bundle?) {
        magic_indicator.navigator = getCommonNavigator()
        ViewPagerHelper.bind(magic_indicator, view_pager)
        mAdapter = TabVideoAdapter(childFragmentManager, mTitles)
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