package com.fph.headlinekotlin.ui.usercenter.bean


import com.fph.headlinekotlin.base.BaseEntity

import java.io.Serializable

/**
 * Created by fengpeihao on 2017/12/7.
 */

class UserInfoBean : BaseEntity(), Serializable {
    /**
     * messsage : 请求成功
     * data : {"nickName":"张三","rank":"1","mycode":"W95E55AD4FL","headUrl":"头像url","phone":"\u201c111111111111\u201d","accessToken":"asdfasfsasfdasfdafd"}
     */

    var data: DataBean? = null

    class DataBean : Serializable {
        /**
         * nickName : 张三
         * rank : 1
         * mycode : W95E55AD4FL
         * headUrl : 头像url
         * phone : “111111111111”
         * accessToken : asdfasfsasfdasfdafd
         * customerInfoId
         * inviteCustomerId
         */

        var nickName: String? = null
        var rank: String? = null
        var mycode: String? = null
        var headUrl: String? = null
        var phone: String? = null
        var accessToken: String? = null
        var customerInfoId: String? = null
        var inviteCustomerId: String? = null
        var platform: Int = 0
    }
}
