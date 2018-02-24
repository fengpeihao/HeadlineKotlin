package com.fph.headlinekotlin.api

import com.feilu.kotlindemo.api.ApiService
import com.feilu.kotlindemo.api.RequestInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit.SECONDS
import javax.net.ssl.*

/**
 * Created by fengpeihao on 2018/1/8.
 */
object ApiModule {

    private val Base_Host = "http://hl-test.51xnsd.com";
    private val Base_Image_Host: String = "http://himage.51xnsd.com/";//图片路径
    private val Base_H5_Host: String = "http://hl-test01-h5.51xnsd.com";//H5路径
    private var mSslContext: SSLContext? = null
    private fun creatRetrofit(): Retrofit {
        loseAgreement();
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(RequestInterceptor())
                .retryOnConnectionFailure(true)
                .sslSocketFactory(mSslContext!!.getSocketFactory())
                .hostnameVerifier(object : HostnameVerifier {
                    override fun verify(p0: String?, p1: SSLSession?): Boolean {
                        return true
                    }
                })
                .connectTimeout(10L, SECONDS)
                .build()
        return Retrofit.Builder()
                .baseUrl(Base_Host)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    //忽略所有https证书
    private fun loseAgreement(){
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate?> {
                return arrayOfNulls<X509Certificate>(0)
            }
        })
        try {
            mSslContext = SSLContext.getInstance("SSL")
            mSslContext!!.init(null, trustAllCerts,
                    java.security.SecureRandom())
        } catch (e: Exception) {
            //            LogUtil.e("ssl出现异常");
        }
    }

    fun provideApiService(): ApiService {
        return creatRetrofit().create(ApiService::class.java)
    }
}