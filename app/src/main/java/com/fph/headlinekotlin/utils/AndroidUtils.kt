package com.fph.headlinekotlin.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.telephony.TelephonyManager
import android.text.TextUtils
import com.feilu.kotlindemo.api.Constant
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.base.App
import com.fph.headlinekotlin.widget.LoadingDialog
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*
import kotlin.experimental.and

/**
 * Created by fengpeihao on 2018/1/8.
 */
object AndroidUtils {

    private var mLoadingDialog: LoadingDialog? = null

    fun getRequestId(): String {
        return UUID.randomUUID().toString().replace("-", "")
    }

    fun getSystemTime(): String {
        return System.currentTimeMillis().toString();
    }

    @SuppressLint("MissingPermission")
    fun getIme(): String {
        var ime = CacheUtils.getString(Constant.deviceId, "");
        if (TextUtils.isEmpty(ime)) {
            val telephonyManager = App.context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            ime = telephonyManager.getDeviceId()
            if (!checkIme(ime)) {
                val sb = StringBuffer()
                sb.append(System.currentTimeMillis()).append((Math.random() * 900).toInt() + 100)
                ime = sb.toString()
            }
            CacheUtils.putString(Constant.deviceId, ime)
        }
        return ime;
    }

    fun getAppVersionName(): String {
        var versionName: String = "0.0.0"
        try {
            val pm = App.context.getPackageManager()
            val pi = pm.getPackageInfo(App.context.getPackageName(), 0)
            versionName = pi.versionName
            if (versionName == null || versionName.length <= 0) {
                return ""
            }
        } catch (e: Exception) {
        }
        return versionName
    }

    fun getMarketId(): String {
        var appType = "0"
        try {
            val appInfo = App.context.getPackageManager()
                    .getApplicationInfo(App.context.getPackageName(),
                            PackageManager.GET_META_DATA)
            appType = appInfo.metaData.get("UMENG_CHANNEL")?.toString()?:"0"
        } catch (e1: Exception) {
            e1.printStackTrace()
        }
        return appType
    }

    fun getSystemModel(): String {
        return android.os.Build.MODEL
    }

    private fun checkIme(ime: String): Boolean {
        if (TextUtils.isEmpty(ime) || ime.length < 3) {
            return false
        }
        var count = 0
        for (i in 0 until ime.length - 1) {
            if (ime[i] == ime[i + 1]) {
                count++
            }
        }
        return if (count == ime.length - 1) {
            false
        } else true
    }

    fun getAndroidSDKVersion(): String {
        return android.os.Build.VERSION.SDK_INT.toString()
    }

    /**
     * 参数加密
     * @param map
     * @return
     */
    fun getSign(map: Map<*, *>, key: String): String {
        val keyset = map.keys as Collection<String>
        val list = ArrayList<String>(keyset)
        Collections.sort(list)
        var str_sort = ""
        for (i in list.indices) {
            str_sort += list.get(i) + "=" + map[list.get(i)] + "&"
        }
        str_sort = str_sort.substring(0, str_sort.length - 1)
        return md5(str_sort, key)
    }

    /**
     * md5加密
     * @param string
     * @param slat 盐值，秘钥
     * @return
     */
    fun md5(string: String, slat: String): String {
        if (TextUtils.isEmpty(string)) {
            return ""
        }
        var md5: MessageDigest? = null
        try {
            md5 = MessageDigest.getInstance("MD5")
            val bytes = md5!!.digest((string + slat).toByteArray())
            var result = ""
            for (b in bytes) {
                var temp = Integer.toHexString((b and 0xff.toByte()).toInt())
                if (temp.length == 1) {
                    temp = "0" + temp
                }
                result += temp
            }
            return result
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }

    fun getAppVer(): String {
        return App.context.resources.getString(R.string.app_ver)
    }

    fun getAppTypeId(): String {
        return "XNTTZK"
    }

    fun showLoading(context: Context) {
        mLoadingDialog = LoadingDialog.Builder(context).build()
        if (!mLoadingDialog!!.isShowing)
            mLoadingDialog!!.showDialog()
    }

    fun cancelLoading() {
        mLoadingDialog?.cancelDialog()
    }


}