package com.fph.headlinekotlin.ui.main.activity

import android.webkit.WebView
import android.webkit.WebViewClient
import com.feilu.kotlindemo.api.Constant
import com.feilu.kotlindemo.base.BaseActivity
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.ui.main.contract.WebViewContract
import com.fph.headlinekotlin.ui.main.presenter.WebViewPresenter
import kotlinx.android.synthetic.main.activity_web_view.*

/**
 * Created by fengpeihao on 2018/2/23.
 */
class WebViewActivity : BaseActivity() , WebViewContract.View{

    private var url: String? = null
    private val mPresenter = WebViewPresenter(this)

    override fun getLayoutId(): Int {
        return R.layout.activity_web_view
    }

    override fun init() {
        val extras = intent.extras
        url = extras.getString(Constant.webUrl,"http://www.baidu.com")
        initWebView()
        mPresenter.getHtmlContent(url!!)
//        web_view.loadUrl(url)
    }

    private fun initWebView() {
        showLoading()
        val settings = web_view.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        web_view.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                cancelLoading()
            }
        }
        getHtmlContentFail()
    }

    override fun getHtmlContentFail() {
        web_view.loadUrl(url)
    }

    override fun getHtmlContentSuccess(content: String) {
        web_view.loadDataWithBaseURL("newsDetails",content,"text/html", "utf-8","")
    }
}