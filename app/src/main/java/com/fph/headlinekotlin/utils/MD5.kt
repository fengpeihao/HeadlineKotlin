package com.fph.headlinekotlin.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * MD5算法类
 */
object MD5 {

    // 全局数组
    private val strDigits = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f")

    // 返回形式为数字跟字符串
    private fun byteToArrayString(bByte: Byte): String {
        var iRet = bByte.toInt()
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256
        }
        val iD1 = iRet / 16
        val iD2 = iRet % 16
        return strDigits[iD1] + strDigits[iD2]
    }

    // 返回形式只为数字
    private fun byteToNum(bByte: Byte): String {
        var iRet = bByte.toInt()
        println("iRet1=" + iRet)
        if (iRet < 0) {
            iRet += 256
        }
        return iRet.toString()
    }

    // 转换字节数组为16进制字串
    private fun byteToString(bByte: ByteArray): String {
        val sBuffer = StringBuffer()
        for (i in bByte.indices) {
            sBuffer.append(byteToArrayString(bByte[i]))
        }
        return sBuffer.toString()
    }

    fun GetMD5Code(strObj: String): String {
        var resultString: String? = null
        try {
            resultString = strObj
            val md = MessageDigest.getInstance("MD5")
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.toByteArray()))
        } catch (ex: NoSuchAlgorithmException) {
            ex.printStackTrace()
        }

        return resultString as String
    }

    /**
     * MD5加密�?2�?
     *
     * @param str
     * @return
     */
    fun toMD5(str: String?): String? {
        return if (str == null || str == "") {
            null
        } else MD5.GetMD5Code(str)

    }

    /**
     * MD5加密�?6�?
     *
     * @param str
     * @return
     */
    fun to16MD5(str: String): String? {
        val md5Str = toMD5(str) ?: return null
        return md5Str.substring(8, 24)
    }
}