package com.fph.headlinekotlin.ui.main.contract

import com.feilu.kotlindemo.base.BaseModel
import com.feilu.kotlindemo.base.BasePresenter
import com.feilu.kotlindemo.base.BaseView
import com.fph.headlinekotlin.ui.main.activity.MainActivity
import com.fph.headlinekotlin.ui.main.model.MainModel

/**
 * Created by fengpeihao on 2018/2/24.
 */
interface MainContract {
    interface View : BaseView {

    }

    interface Model : BaseModel{

    }

    abstract class Presenter : BasePresenter<MainActivity, MainModel>(){

    }
}