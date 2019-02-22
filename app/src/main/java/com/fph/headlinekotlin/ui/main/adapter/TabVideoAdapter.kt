package com.fph.headlinekotlin.ui.main.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.fph.headlinekotlin.ui.main.bean.ChannelBean
import com.fph.headlinekotlin.ui.video.fragment.VideoFragment

/**
 * Created by fengpeihao on 2018/1/12.
 */
class TabVideoAdapter(fm: FragmentManager?, titles: ArrayList<ChannelBean>) : FragmentStatePagerAdapter(fm) {

    private var mTitles: ArrayList<ChannelBean>? = titles

    override fun getItem(position: Int): Fragment {
        val videoFragment = VideoFragment()
        val bundle = Bundle()
        bundle.putString("type", mTitles!!.get(position).type)
        videoFragment.arguments = bundle
        return videoFragment
    }

    override fun getCount(): Int {
        return mTitles?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles?.get(position)?.name ?: ""
    }
}