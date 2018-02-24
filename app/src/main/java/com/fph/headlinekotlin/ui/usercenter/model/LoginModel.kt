package com.fph.headlinekotlin.ui.usercenter.model

import com.feilu.kotlindemo.base.BaseActivity
import com.feilu.kotlindemo.base.CommonSubscriber
import com.feilu.kotlindemo.base.RxUtils
import com.fph.headlinekotlin.base.BaseEntity
import com.fph.headlinekotlin.ui.usercenter.bean.CheckRegistBean
import com.fph.headlinekotlin.ui.usercenter.bean.UserInfoBean
import com.fph.headlinekotlin.ui.usercenter.contract.LoginContract

/**
 * Created by fengpeihao on 2018/1/9.
 */
class LoginModel : LoginContract.Model {
    override fun getSmscode(phoneNum: String, smsCodeType: Int, subscriber: CommonSubscriber<BaseEntity>, context: BaseActivity) {
        apiService.getSmsCode(phoneNum, smsCodeType)
                .compose(RxUtils.rxSchedulerHelper(context))
                .subscribeWith(subscriber)
    }

    override fun checkRegist(phoneNum: String, subscriber: CommonSubscriber<CheckRegistBean>, context: BaseActivity) {
        apiService.checkRegist(phoneNum)
                .compose(RxUtils.rxSchedulerHelper(context))
                .subscribeWith(subscriber)
    }

    override fun login(phone: String, smsCode: String, smsCodeType: Int, subscriber: CommonSubscriber<UserInfoBean>, context: BaseActivity) {
        if (smsCodeType == 2) {//注册
            apiService.regist(phone, "aaa123456", 3, smsCode, smsCodeType)
                    .compose(RxUtils.rxSchedulerHelper(context))
                    .subscribeWith(subscriber)
        } else {
            apiService.login(phone, smsCode)
                    .compose(RxUtils.rxSchedulerHelper(context))
                    .subscribeWith(subscriber)
        }
    }
}