package com.fph.headlinekotlin.ui.usercenter.contract

import com.feilu.kotlindemo.base.*
import com.fph.headlinekotlin.base.BaseEntity
import com.fph.headlinekotlin.ui.usercenter.activity.LoginActivity
import com.fph.headlinekotlin.ui.usercenter.bean.CheckRegistBean
import com.fph.headlinekotlin.ui.usercenter.bean.UserInfoBean
import com.fph.headlinekotlin.ui.usercenter.model.LoginModel

/**
 * Created by fengpeihao on 2018/1/9.
 */
interface LoginContract {
    interface View : BaseView {
        fun getSmsCodeType(smsCodeType: Int)

        fun onTimerTick(millisInFuture: Long)

        fun onTimerFinish()
    }

    interface Model : BaseModel {
        fun checkRegist(phoneNum: String, subscriber: CommonSubscriber<CheckRegistBean>, context: BaseActivity)

        fun getSmscode(phoneNum: String, smsCodeType: Int, subscriber: CommonSubscriber<BaseEntity>, context: BaseActivity);

        fun login(phone: String, smsCode: String, smsCodeType: Int, subscriber: CommonSubscriber<UserInfoBean>, context: BaseActivity);

    }

    abstract class Presenter : BasePresenter<LoginActivity, LoginModel>() {
        abstract fun checkRegist(phoneNum: String)

        abstract fun getSmsCode(phoneNum: String, smsCodeType: Int);

        abstract fun login(phone: String, smsCode: String, smsCodeType: Int);

        abstract fun startTimer()

        abstract fun cancelTimer()
    }
}