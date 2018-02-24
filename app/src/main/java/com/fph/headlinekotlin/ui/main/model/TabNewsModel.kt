package com.fph.headlinekotlin.ui.main.model

import com.feilu.kotlindemo.base.BaseFragment
import com.feilu.kotlindemo.base.Common2Subscriber
import com.feilu.kotlindemo.base.RxUtils
import com.fph.headlinekotlin.ui.main.bean.ChannelBean
import com.fph.headlinekotlin.ui.main.contract.TabNewsContract
import com.fph.headlinekotlin.utils.AccountUtils
import com.fph.headlinekotlin.utils.AndroidUtils

/**
 * Created by fengpeihao on 2018/1/12.
 */
class TabNewsModel: TabNewsContract.Model {
    override fun getTitles(subscriber: Common2Subscriber<ArrayList<ChannelBean>>, context: BaseFragment) {
        apiService.getChannel("https://tjv1.dftoutiao.com/app/columns02",AndroidUtils.getIme(),
                AndroidUtils.getMarketId(),
                AndroidUtils.getAppTypeId(),
                AndroidUtils.getAppVer(),
                AndroidUtils.getAppVersionName(),
                AndroidUtils.getAndroidSDKVersion(),
                AccountUtils.customerId).
                compose(RxUtils.rxSchedulerHelper(context)).
                subscribeWith(subscriber)
    }
}