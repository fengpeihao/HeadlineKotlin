package com.fph.headlinekotlin.ui.main.adapter

import android.content.Context
import android.support.v4.view.ViewPager
import android.text.SpannableStringBuilder
import android.util.TypedValue
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.TextView
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.ui.main.bean.ChannelBean
import com.fph.headlinekotlin.widget.magicindicator.buildins.UIUtil
import com.fph.headlinekotlin.widget.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import com.fph.headlinekotlin.widget.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import com.fph.headlinekotlin.widget.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import com.fph.headlinekotlin.widget.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import com.fph.headlinekotlin.widget.magicindicator.buildins.commonnavigator.titles.ColorFlipPagerTitleView

/**
 * Created by fengpeihao on 2018/1/12.
 */
class NewsNavigatorAdapter : CommonNavigatorAdapter {

    private var mTitles: ArrayList<ChannelBean>? = null
    private var mViewPager: ViewPager? = null

    constructor(titles: ArrayList<ChannelBean>, viewPager: ViewPager) : super() {
        mTitles = titles
        mViewPager = viewPager
    }


    override fun getCount(): Int {
        return mTitles?.size ?: 0
    }

    override fun getTitleView(context: Context, index: Int): IPagerTitleView {
        val simplePagerTitleView = ColorFlipPagerTitleView(context)
        val sBuilder = SpannableStringBuilder()
        val title = mTitles?.get(index)?.name
        sBuilder.append(title)
        simplePagerTitleView.setText(sBuilder, TextView.BufferType.SPANNABLE)
        simplePagerTitleView.normalColor = context.resources.getColor(R.color.text_color_light)
        simplePagerTitleView.selectedColor = context.resources.getColor(R.color.theme_color)
        simplePagerTitleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, UIUtil.dip2px(context, 16.0).toFloat())
        simplePagerTitleView.setOnClickListener { mViewPager?.setCurrentItem(index) }
        return simplePagerTitleView
    }

    override fun getIndicator(context: Context): IPagerIndicator {
        val indicator = LinePagerIndicator(context)
        indicator.setMode(LinePagerIndicator.MODE_EXACTLY)
        indicator.setLineHeight(UIUtil.dip2px(context, 2.0).toFloat())
        indicator.setLineWidth(UIUtil.dip2px(context, 20.0).toFloat())
        indicator.setRoundRadius(UIUtil.dip2px(context, 3.0).toFloat())
        indicator.setStartInterpolator(AccelerateInterpolator())
        indicator.setEndInterpolator(DecelerateInterpolator(2.0f))
        indicator.setColors(context.resources.getColor(R.color.theme_color))
        return indicator
    }
}