package com.feilu.kotlindemo.base

import com.feilu.kotlindemo.api.ApiService
import com.fph.headlinekotlin.api.ApiModule

/**
 * Created by fengpeihao on 2017/7/22.
 */

interface BaseModel {
    val apiService: ApiService
        get() = ApiModule.provideApiService()
}
