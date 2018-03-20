package com.fph.headlinekotlin.ui.main.activity

import android.graphics.Bitmap
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import com.feilu.kotlindemo.api.Constant
import com.feilu.kotlindemo.base.BaseActivity
import com.fph.headlinekotlin.R
import kotlinx.android.synthetic.main.activity_web_view.*

/**
 * Created by fengpeihao on 2018/2/23.
 */
class WebViewActivity : BaseActivity() {

    private var url: String? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_web_view
    }

    override fun init() {
        val extras = intent.extras
        url = extras.getString(Constant.webUrl)
        web_view.loadUrl(url)
    }

    private fun initWebView() {
        val settings = web_view.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        web_view.webViewClient = object : WebViewClient() {
            override fun shouldInterceptRequest(view: WebView?, url: String?): WebResourceResponse {
                return super.shouldInterceptRequest(view, url)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                cancelLoading()
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                showLoading()
            }
        }
    }
}