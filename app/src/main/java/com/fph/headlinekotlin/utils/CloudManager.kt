package com.fph.headlinekotlin.utils

import com.feilu.kotlindemo.api.Constant
import com.feilu.kotlindemo.base.Common2Subscriber
import com.feilu.kotlindemo.base.RxUtils
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.api.ApiModule
import com.fph.headlinekotlin.base.App
import java.math.BigInteger
import kotlin.experimental.and
import kotlin.experimental.xor

object CloudManager {

    val SP_ENCRYPT_TYPE = "EncryptHelp_SP_encrypt_type"

    val cloudKeyFromLocal: String
        get() = CacheUtils.getString(Constant.CLOUDKEYURL_KEY, "")

    fun fetchCloudKey() {
        ApiModule.provideApiService().getCloudKey(getUrl(Constant.CLOUDKEYURL_KEY))
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(object : Common2Subscriber<Array<String>>() {
                    override fun netError(message: String) {

                    }

                    override fun getData(t: Array<String>) {
                        val cloudKey = encrypt(t[0]) as String
                        CacheUtils.putString(Constant.CLOUD_KEY, cloudKey)
                    }
                })
    }

    private fun getUrl(url: String): String {
        var url = url
        if (url.contains("?")) {
            url = url + "&appver=" + App.context.resources.getString(R.string.app_ver)
        } else {
            url = url + "?appver=" + App.context.resources.getString(R.string.app_ver)
        }
        return url
    }

    /**
     * 加密算法
     *
     * @param encryptKey
     * 加密的key
     * @return
     */
    private fun encrypt(encryptKey: String?): String? {
        if (encryptKey == null || encryptKey.length != 13) {
            return null
        }

        val str1 = encryptKey.substring(1, 9)
        val str2 = encryptKey.substring(10)

        val str2CharArray = str2.toCharArray()
        var leftNum = str2CharArray[0].toInt() % 8
        leftNum = if (leftNum < 3) 3 else leftNum
        var rightNum = str2CharArray[1].toInt() % 8
        rightNum = if (rightNum < 3) 3 else rightNum

        var str3 = str1.substring(0, leftNum)
        var str4 = ""
        for (i in str1.length - 1 downTo str1.length - rightNum) {
            str4 += str1[i]
        }
        if (str3.length > str4.length) {
            val num = str3.length - str4.length
            val charArray = str4.toCharArray()
            for (i in 0 until num) {
                str4 += charArray[i % charArray.size]
            }
        } else if (str4.length > str3.length) {
            val num = str4.length - str3.length
            val charArray = str3.toCharArray()
            for (i in 0 until num) {
                str3 += charArray[i % charArray.size]
            }
        }

        val str3Byte = str3.toByteArray()
        val str4Byte = str4.toByteArray()
        val result = IntArray(str3.length)
        val type = str2CharArray[2].toInt() % 4

        CacheUtils.putInt(SP_ENCRYPT_TYPE, type)

        when (type) {
            0 -> for (i in result.indices) {
                result[i] = str3Byte[i] + str4Byte[i]
            }

            1 -> for (i in result.indices) {
                result[i] = Math.abs(str3Byte[i] - str4Byte[i])
            }

            2 -> for (i in result.indices) {
                result[i] = (str3Byte[i] and str4Byte[i]).toInt()
            }

            3 -> for (i in result.indices) {
                result[i] = (str3Byte[i] xor str4Byte[i]).toInt()
            }
        }

        var resultStr: String? = null
        for (i in result.indices) {
            var tmp = Integer.toHexString(result[i])
            if (tmp.length == 1) {
                tmp = "0" + tmp
            }

            if (resultStr == null) {
                resultStr = tmp
            } else {
                resultStr += tmp
            }
        }

        for (i in resultStr!!.length..15) {
            resultStr += "0"
        }

        val bigInteger = BigInteger(resultStr, 16)

        val str = "toutiao" + bigInteger.toString() + encryptKey

        return MD5.to16MD5(str)
    }
}
