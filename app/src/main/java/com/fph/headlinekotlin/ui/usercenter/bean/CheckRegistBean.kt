package com.fph.headlinekotlin.ui.usercenter.bean

import com.fph.headlinekotlin.base.BaseEntity

/**
 * Created by fengpeihao on 2018/1/9.
 */
class CheckRegistBean: BaseEntity() {
    /**
     * data : {"logo":1}
     */

    private var data: DataBean? = null

    fun getData(): DataBean? {
        return data
    }

    fun setData(data: DataBean) {
        this.data = data
    }

    class DataBean {
        /**
         * logo : 1  (1-新用户,2老用户)
         */

        var logo: Int = 0
    }
}