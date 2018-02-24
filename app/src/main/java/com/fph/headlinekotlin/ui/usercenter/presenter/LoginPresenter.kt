package com.fph.headlinekotlin.ui.usercenter.presenter

import android.os.CountDownTimer
import com.feilu.kotlindemo.base.CommonSubscriber
import com.fph.headlinekotlin.base.BaseEntity
import com.fph.headlinekotlin.ui.usercenter.activity.LoginActivity
import com.fph.headlinekotlin.ui.usercenter.bean.CheckRegistBean
import com.fph.headlinekotlin.ui.usercenter.bean.UserInfoBean
import com.fph.headlinekotlin.ui.usercenter.contract.LoginContract
import com.fph.headlinekotlin.ui.usercenter.model.LoginModel
import com.fph.headlinekotlin.utils.AccountUtils

/**
 * Created by fengpeihao on 2018/1/9.
 */
class LoginPresenter : LoginContract.Presenter {

    private val countDownInterval = 1000L;
    private val millisInFuture = 60 * countDownInterval;
    private var countDownTimer: CountDownTimer? = null

    constructor(view: LoginActivity) {
        setVM(view, LoginModel())
    }

    override fun startTimer() {
        if (countDownTimer == null) {
            countDownTimer = object : CountDownTimer(millisInFuture, countDownInterval) {
                override fun onFinish() {

                }

                override fun onTick(millisUntilFinished: Long) {

                }
            }.start()
        }else{
            countDownTimer!!.onTick(millisInFuture)
            countDownTimer!!.start()
        }
    }

    override fun cancelTimer() {
        countDownTimer?.cancel()
    }

    override fun getSmsCode(phoneNum: String, smsCodeType: Int) {
        mModel.getSmscode(phoneNum, smsCodeType, object : CommonSubscriber<BaseEntity>(mView, false, true) {
            override fun netError(message: String) {
                mView.onTimerFinish()
                mView.showToast(message)
            }

            override fun showExtraOp(message: String) {
                mView.showToast(message)
                mView.onTimerFinish()
            }

            override fun getData(t: BaseEntity) {
                startTimer()
                mView.showToast("验证码发送成功")
                mView.getSmsCodeType(smsCodeType)
            }
        }, mView)
    }

    override fun checkRegist(phoneNum: String) {
        mModel.checkRegist(phoneNum, object : CommonSubscriber<CheckRegistBean>(mView, true, false) {
            override fun netError(message: String) {
                mView.showToast(message)
            }

            override fun showExtraOp(message: String) {
                mView.showToast(message)
            }

            override fun getData(t: CheckRegistBean) {
                var smsCodeType = 2;
                if (t.getData()?.logo ?: 1 == 2) {
                    smsCodeType = 1
                }
                getSmsCode(phoneNum, smsCodeType)
            }
        }, mView)
    }

    override fun login(phone: String, smsCode: String, smsCodeType: Int) {
        mModel.login(phone, smsCode, smsCodeType, object : CommonSubscriber<UserInfoBean>(mView) {
            override fun netError(message: String) {
                mView.showToast(message)
            }

            override fun showExtraOp(message: String) {
                mView.showToast(message)
            }

            override fun getData(t: UserInfoBean) {
                AccountUtils.saveAccountInfo(t, false)
                mView.finish()
            }
        }, mView)
    }
}