package com.fph.headlinekotlin.utils

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils

import com.fph.headlinekotlin.base.App
import com.fph.headlinekotlin.ui.usercenter.bean.UserInfoBean

/**
 * Created by fengpeihao on 2017/12/9.
 */

object AccountUtils {

    private val SP_NAME = "account_info"
    private val sp: SharedPreferences = App.context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    private val ACCOUNT_TOKEN = "account_token"
    private val PHONE_NUM = "phone_num"
    private val HEAD_PORTRAIT = "head_portrait"
    private val NICK_NAME = "nick_name"
    private val INVITATION_CODE = "invitation_code"
    private val RANK = "rank"
    private val CUSTOMER_ID = "customer_id"
    private val PLAT_FORM = "plat_form"
    private val COIN_ACCOUNT_ID = "coin_account_id"
    private val MONEY_ACCOUNT_ID = "money_account_id"
    private val INVITE_CUSTOMER_ID = "invite_customer_id"

    /**
     * 获取用户金币账号
     *
     * @return
     */
    /**
     * 存储用户金币账号
     *
     * @return
     */
    var coinAccountId: String
        get() = getString(COIN_ACCOUNT_ID, "")!!
        set(accountId) = putString(COIN_ACCOUNT_ID, accountId)

    /**
     * 获取用户零钱账号
     *
     * @return
     */
    /**
     * 存储用户零钱账号
     *
     * @return
     */
    var moneyAccountId: String
        get() = getString(MONEY_ACCOUNT_ID, "")!!
        set(accountId) = putString(MONEY_ACCOUNT_ID, accountId)

    /**
     * 获取accountToken
     *
     * @return 获取accountToken
     */
    var accessToken: String
        get() = getString(ACCOUNT_TOKEN, "-1")!!
        set(accessToken) = putString(NICK_NAME, accessToken)

    /**
     * 获取用户手机号
     *
     * @return
     */
    var phoneNum: String
        get() = getString(PHONE_NUM, "")!!
        set(phoneNum) = putString(NICK_NAME, phoneNum)

    /**
     * 获取用户头像url
     *
     * @return
     */
    var headPortrait: String
        get() = getString(HEAD_PORTRAIT, "")!!
        set(headPortrait) = putString(NICK_NAME, headPortrait)

    /**
     * 获取用户昵称
     *
     * @return
     */
    var nickName: String
        get() = getString(NICK_NAME, "")!!
        set(nickName) = putString(NICK_NAME, nickName)

    /**
     * 获取用户邀请码
     *
     * @return
     */
    var invitationCode: String
        get() = getString(INVITATION_CODE, "")!!
        set(invitationCode) = putString(INVITATION_CODE, invitationCode)

    /**
     * 获取用户id
     *
     * @return
     */
    var customerId: String
        get() = getString(CUSTOMER_ID, "-1")!!
        set(customerId) = putString(INVITATION_CODE, customerId)

    /**
     * 获取用户登录方式 1 手机登录  3 qq登录  4 微信登录  5新浪微博登录
     *
     * @return
     */
    var platForm: Int
        get() = getInt(PLAT_FORM, 1)
        set(platForm) = putInt(INVITATION_CODE, platForm)

    /**
     * 获取用户等级
     *
     * @return
     */
    var rank: String
        get() = getString(RANK, "")!!
        set(rank) = putString(INVITATION_CODE, rank)

    /**
     * 获取用户邀请人id
     *
     * @return
     */
    var inviteCustomerId: String
        get() = getString(INVITE_CUSTOMER_ID, "")!!
        set(inviteCustomerId) = putString(INVITATION_CODE, inviteCustomerId)

    /**
     * 用户是否在线
     *
     * @return
     */
    val isOnLine: Boolean
        get() = !TextUtils.isEmpty(accessToken)


    private fun putBoolean(key: String, value: Boolean?) {
        sp.edit().putBoolean(key, value!!).apply()
    }

    private fun getBoolean(key: String, defValue: Boolean?): Boolean {
        return sp.getBoolean(key, defValue!!)
    }

    /**
     * 缓存字符串
     *
     * @param key
     * @param value
     */
    fun putString(key: String, value: String?) {
        sp.edit().putString(key, value).apply()
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    private fun getString(key: String, defValue: String): String? {
        return sp.getString(key, defValue)
    }

    /**
     * @param key
     * @param value
     */
    private fun putInt(key: String, value: Int) {
        sp.edit().putInt(key, value).apply()
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    private fun getInt(key: String, defValue: Int): Int {
        return sp.getInt(key, defValue)
    }

    /**
     * @param key
     * @param value
     */
    private fun putLong(key: String, value: Long) {
        sp.edit().putLong(key, value).apply()
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    private fun getLong(key: String, defValue: Long): Long {
        return sp.getLong(key, defValue)
    }

    /**
     * 清除用户信息
     *
     * @return
     */
    fun clearAccountInfo() {
        sp.edit().clear().apply()
    }

    /**
     * 存储用户信息
     *
     * @param userInfoBean
     */
    fun saveAccountInfo(userInfoBean: UserInfoBean?, isFormUserInfo: Boolean) {
        if (userInfoBean == null || userInfoBean.data == null) {
            return
        }
        val dataBean = userInfoBean.data
        if (!isFormUserInfo) {
            putString(ACCOUNT_TOKEN, dataBean!!.accessToken)
            putInt(PLAT_FORM, dataBean.platform)
        }
        putString(PHONE_NUM, dataBean!!.phone)
        putString(NICK_NAME, dataBean.nickName)
        putString(RANK, dataBean.rank)
        putString(INVITATION_CODE, dataBean.mycode)
        putString(HEAD_PORTRAIT, dataBean.headUrl)
        putString(CUSTOMER_ID, dataBean.customerInfoId)
        putString(INVITE_CUSTOMER_ID, dataBean.inviteCustomerId)
    }
}
