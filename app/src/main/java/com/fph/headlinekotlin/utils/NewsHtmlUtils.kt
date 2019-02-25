package com.fph.headlinekotlin.utils

import android.content.Context
import android.text.TextUtils
import com.fph.headlinekotlin.base.App
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File

/**
 * Created by fengpeihao on 2018/3/20.
 */
object NewsHtmlUtils {
    private val newDocument = Jsoup.parse(getTemplate("page.tmpl"))

    fun getHtmlContent(context: Context, oldContent: String): String {
        val oldDocument = Jsoup.parse(oldContent)
        val title = getContentTitle(oldDocument)
        val htmlContent = getHtmlContent(oldDocument)
        val htmlSrc = getHtmlSrc(oldDocument)

        val linkElements = newDocument.getElementsByTag("link")
        val linkStyle = linkElements[0]
        val path = "file:///android_asset/static_day.css"
        linkStyle.attr("href", path)
        linkStyle.after(createLinkOnUri(path))

        val sourcelinkElements = oldDocument.getElementsByTag("link")
        for (linkElement in sourcelinkElements) {
            val href = linkElement.attr("href")
            val fileName = getCssFileNameFromUrl(href)
            var path = ""
            path = FileUtils.getCachePath(context, fileName)

            val file = File(path)
            var cssUrl = href
            if (file.exists() && file.length() > 10) {
                cssUrl = "file://$path"
            }
            val linkHtml = createLinkOnUri(cssUrl)
            linkStyle.before(linkHtml)
        }

        newDocument.select("title").html(title)
        newDocument.select("#title").select(".title").html(title)
        newDocument.select("#title").select(".src").html(htmlSrc)
        newDocument.select("#content").html(htmlContent)
        return newDocument.toString()
    }

    private fun getTemplate(fileName: String): String {
        val inputStream = App.context.resources.assets.open(fileName)
        val length = inputStream.available()
        val bytes = ByteArray(length)
        inputStream.read(bytes)
        return String(bytes)
    }

    /**
     * 获取新闻来源
     *
     * @param document
     * @return
     */
    private fun getHtmlSrc(document: Document?): String? {
        if (document?.select("#title")?.size ?: 0 <= 0) {
            return null
        }
        val titleDiv = document!!.select("#title")[0]
        return titleDiv.getElementsByClass("src").text()
    }

    /**
     * 获取新闻内容
     */
    private fun getHtmlContent(document: Document?): String? {
        val bodyElement = document?.body()

        return bodyElement?.getElementById("content")?.html()
    }

    /**
     * 获取新闻内容标题
     */
    private fun getContentTitle(document: Document?): String? {
        if (document?.select("#title") == null || document.select("#title").size <= 0) {
            return null
        }
        var contentTitle: String? = null
        try {
            val titleDiv = document.select("#title")[0]
            contentTitle = titleDiv.getElementsByClass("title").text()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return contentTitle
    }

    private fun createLinkOnUri(uri: String): String {
        return "<link rel='stylesheet' href=\"$uri\"/>"
    }

    /**
     * 获取CSS文件名
     *
     * @param url
     * @return
     */
    private fun getCssFileNameFromUrl(url: String): String {
        if (TextUtils.isEmpty(url)) {
            return url
        }

        val strArray = url.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return if (strArray.size <= 0) {
            url
        } else strArray[strArray.size - 1]

    }
}