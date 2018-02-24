package com.fph.headlinekotlin.base

import android.content.Context
import com.tencent.tinker.loader.app.TinkerApplication
import com.tencent.tinker.loader.shareutil.ShareConstants

/**
 * Created by fengpeihao on 2018/1/8.
 */
class App : TinkerApplication {
    constructor() : super(
            //tinkerFlags, which types is supported
            //dex only, library only, all support
            ShareConstants.TINKER_ENABLE_ALL,
            // This is passed as a string so the shell application does not
            // have a binary dependency on your ApplicationLifeCycle class.
            "com.fph.headlinekotlin.hotfix.ApplicationDelegate"
    ) {
        context = this
    }

    companion object {
        lateinit var context: Context;
    }
}