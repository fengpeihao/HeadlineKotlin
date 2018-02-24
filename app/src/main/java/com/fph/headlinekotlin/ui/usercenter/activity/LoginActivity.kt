package com.fph.headlinekotlin.ui.usercenter.activity

import android.text.TextUtils
import com.feilu.kotlindemo.base.BaseActivity
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.ui.usercenter.contract.LoginContract
import com.fph.headlinekotlin.ui.usercenter.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by fengpeihao on 2018/1/9.
 */
class LoginActivity : BaseActivity(), LoginContract.View {

    private var smsCodeType = 1;

    private val mPresenter: LoginPresenter = LoginPresenter(this)

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun init() {
        img_close.setOnClickListener { finish() }
        tv_get_code.setOnClickListener {
            if (TextUtils.isEmpty(edt_phone_num.text)) {
                showToast("请输入手机号")
                return@setOnClickListener
            }
            tv_get_code.isEnabled = false
            mPresenter.checkRegist(edt_phone_num.text.toString())
        }
        btn_login.setOnClickListener {
            if (TextUtils.isEmpty(edt_phone_num.text)) {
                showToast("请输入手机号")
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(edt_code.text)) {
                showToast("请输入验证码")
                return@setOnClickListener
            }
            mPresenter.login(edt_phone_num.text.toString(), edt_code.text.toString(), smsCodeType)
        }
    }

    override fun onTimerTick(millisUntilFinished: Long) {
        tv_get_code.setText((millisUntilFinished / 1000).toString() + "秒后重新获取")
    }

    override fun onTimerFinish() {
        tv_get_code.setText("重新获取验证码")
        tv_get_code.isEnabled = true
    }

    override fun getSmsCodeType(smsCodeType: Int) {
        this.smsCodeType = smsCodeType
    }
}