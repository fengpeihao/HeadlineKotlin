package com.fph.headlinekotlin.ui.main.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.fph.headlinekotlin.ui.main.bean.ChannelBean
import com.fph.headlinekotlin.ui.news.fragment.NewsFragment

/**
 * Created by fengpeihao on 2018/1/12.
 */
class TabNewsAdapter : FragmentStatePagerAdapter {

    private var mTitles: ArrayList<ChannelBean>? = null

    constructor(fm: FragmentManager, titles: ArrayList<ChannelBean>) : super(fm) {
        mTitles = titles
    }

    override fun getItem(position: Int): Fragment {
        val newsFragment = NewsFragment()
        val bundle = Bundle()
        bundle.putString("type", mTitles!!.get(position).type)
        newsFragment.arguments = bundle
        return newsFragment
    }

    override fun getCount(): Int {
        return mTitles?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles?.get(position)?.name ?: ""
    }
}