package com.fph.headlinekotlin.utils

import android.content.Context
import android.os.Environment
import android.text.TextUtils
import java.io.File
import java.io.FileOutputStream

object FileUtils {

    /**
     * 获取文件路径
     */
    fun getCachePath(context: Context, fileName: String): String {
        return File(context.cacheDir, fileName).absolutePath
    }

    fun getCacheFile(context: Context, fileName: String):File{
        return File(context.cacheDir, fileName)
    }

    /**
     * 获取CSS文件名
     * @param url
     */
    fun getCssFileNameFromUrl(url: String): String {
        if (TextUtils.isEmpty(url)) {
            return url
        }
        val strArray = url.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return if (strArray.isEmpty()) {
            url
        } else strArray[strArray.size - 1]
    }

    /**
     * 保存文件
     */
    fun saveFile(context: Context, fileName: String, data: String): Boolean {
        var bRet = true
        val fos: FileOutputStream
        try {
            fos = FileOutputStream(File(context.cacheDir, fileName))
            fos.write(data.toByteArray())
            fos.close()
        } catch (e: Exception) {
            e.printStackTrace()
            bRet = false
        }

        return bRet
    }
}