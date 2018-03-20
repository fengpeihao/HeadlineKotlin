package com.feilu.kotlindemo.api

import com.fph.headlinekotlin.base.BaseEntity
import com.fph.headlinekotlin.ui.main.bean.ChannelBean
import com.fph.headlinekotlin.ui.main.bean.Patch
import com.fph.headlinekotlin.ui.news.bean.NewsListBean
import com.fph.headlinekotlin.ui.usercenter.bean.CheckRegistBean
import com.fph.headlinekotlin.ui.usercenter.bean.UserInfoBean
import io.reactivex.Flowable
import retrofit2.http.*

/**
 * Created by fengpeihao on 2017/7/13.
 */
interface ApiService {
    /*
     * 校验手机号是否注册
     */
    @GET("/apiGateway/user/checkNewandoldusers")
    fun checkRegist(@Query("phone") phoneNum: String): Flowable<CheckRegistBean>

    /**
     * 获取验证码
     */
    @GET("/apiGateway/user/getSmsCode")
    fun getSmsCode(@Query("phone") phoneNum: String,
                   @Query("smsCodeType") smsCodeType: Int): Flowable<BaseEntity>

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("/apiGateway/user/registerNew")
    fun regist(@Field("phone") phone: String,
               @Field("pwd") pwd: String,
               @Field("regFrom") regFrom: Int,
               @Field("smsCode") smsCode: String,
               @Field("smsCodeType") smsCodeType: Int): Flowable<UserInfoBean>

    /**
     * 验证码登录
     */
    @GET("/apiGateway/user/smsCodeLogin")
    fun login(@Query("phone") phone: String,
              @Query("smsCode") smsCode: String): Flowable<UserInfoBean>

    /**
     * 获取新闻分类列表
     */
    @FormUrlEncoded
    @POST
    fun getChannel(@Url url: String,
                   @Field("ime") ime: String,
                   @Field("appqid") appqid: String,
                   @Field("apptypeid") apptypeid: String,
                   @Field("ver") ver: String,
                   @Field("os") os: String,
                   @Field("ttaccid") ttaccid: String,
                   @Field("AndroidId") AndroidId: String): Flowable<ArrayList<ChannelBean>>

    /**
     * 获取新闻流
     */
    @FormUrlEncoded
    @POST
    fun getNewsList(@Url url: String,
                    @Field("startkey") startkey: String,
                    @Field("newkey") newkey: String,
                    @Field("pgnum") pgnum: Int,
                    @Field("idx") idx: Int,
                    @Field("type") type: String,
                    @Field("ime") ime: String,
                    @Field("key") key: String,
                    @Field("apptypeid") apptypeid: String,
                    @Field("appver") appver: String,
                    @Field("position") position: String,
                    @Field("param") param: String): Flowable<NewsListBean>

    /**
     * 获取cloudkey
     */
    @GET
    fun getCloudKey(@Url url: String): Flowable<Array<String>>

    //查询app是否有补丁版本
    @FormUrlEncoded
    @POST("/userCenter/appVersion/getPatch.do")
    fun queryPatch(@Field("channel") channel: String,
                   @Field("baseVersionName") baseVersionName: String,
                   @Field("clientType") clientType: String,
                   @Field("patchVersion") patchVersion: String): Flowable<Patch>

    @GET
    fun getHtmlContent(@Url url: String): Flowable<String>
}
