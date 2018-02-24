package com.fph.headlinekotlin.ui.main.contract

import com.feilu.kotlindemo.base.*
import com.fph.headlinekotlin.ui.main.bean.ChannelBean
import com.fph.headlinekotlin.ui.main.fragment.TabNewsFragment
import com.fph.headlinekotlin.ui.main.model.TabNewsModel

/**
 * Created by fengpeihao on 2018/1/12.
 */
interface TabNewsContract {

    interface View : BaseView {
        fun getTitles(titles: ArrayList<ChannelBean>)
    }

    interface Model : BaseModel {
        fun getTitles(subscriber: Common2Subscriber<ArrayList<ChannelBean>>, context: BaseFragment)
    }

    abstract class Presenter : BasePresenter<TabNewsFragment, TabNewsModel>() {
        abstract fun getTitles()
    }
}