package com.fph.headlinekotlin.ui.main.bean


import com.fph.headlinekotlin.base.BaseEntity

/**
 * Created by sahara on 2017/4/25.
 */

class Patch : BaseEntity() {


    /**
     * data : {"baseVersionName":"1.3.0","encryption":"adfadfasdfasdf","patchVersion":"1.0","url":"http://","versionCode":7,"versionName":"1.3.0"}
     */

    var data: DataBean? = null

    class DataBean {
        /**
         * baseVersionName : 1.3.0
         * encryption : adfadfasdfasdf
         * patchVersion : 1.0
         * url : http://
         * versionCode : 7
         * versionName : 1.3.0
         */

        var baseVersionName: String? = null
        var encryption: String? = null
        var patchVersion: String? = null
        var url: String? = null
        var versionCode: Int = 0
        var versionName: String? = null
    }
}
