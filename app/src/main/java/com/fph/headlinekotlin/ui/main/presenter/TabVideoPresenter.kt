package com.fph.headlinekotlin.ui.main.presenter

import com.feilu.kotlindemo.base.Common2Subscriber
import com.fph.headlinekotlin.ui.main.bean.ChannelBean
import com.fph.headlinekotlin.ui.main.contract.TabVideoContract
import com.fph.headlinekotlin.ui.main.fragment.TabVideoFragment
import com.fph.headlinekotlin.ui.main.model.TabVideoModel

/**
 * Created by fengpeihao on 2018/1/12.
 */
class TabVideoPresenter : TabVideoContract.Presenter {
    constructor(view: TabVideoFragment) : super() {
        setVM(view, TabVideoModel())
    }

    override fun getTitles() {
        mModel.getTitles(object : Common2Subscriber<ArrayList<ChannelBean>>(mView.context) {
            override fun netError(message: String) {

            }

            override fun getData(t: ArrayList<ChannelBean>) {
                val arrayList = ArrayList<ChannelBean>()
                for (i in t.indices) {
                    if ("1".equals(t.get(i).isup))
                        arrayList.add(t.get(i))
                }
                mView.getTitles(arrayList)
            }
        }, mView)
    }
}