package com.fph.headlinekotlin.ui.main.contract

import com.feilu.kotlindemo.base.*
import com.fph.headlinekotlin.ui.main.bean.ChannelBean
import com.fph.headlinekotlin.ui.main.fragment.TabVideoFragment
import com.fph.headlinekotlin.ui.main.model.TabVideoModel

/**
 * Created by fengpeihao on 2018/1/12.
 */
interface TabVideoContract {

    interface View : BaseView {
        fun getTitles(titles: ArrayList<ChannelBean>)
    }

    interface Model : BaseModel {
        fun getTitles(subscriber: Common2Subscriber<ArrayList<ChannelBean>>, context: BaseFragment)
    }

    abstract class Presenter : BasePresenter<TabVideoFragment, TabVideoModel>() {
        abstract fun getTitles()
    }
}