package com.fph.headlinekotlin.hotfix.log;

import android.util.Log;

import com.fph.headlinekotlin.BuildConfig;
import com.fph.headlinekotlin.hotfix.listener.MyPatchListener;


/**
 * Created by admin on 2017/7/10.
 */

public class HotfixLogcat {
    private static final boolean isShowLog = true;
    public static void log(String message){
        if(BuildConfig.BUILD_TYPE.equalsIgnoreCase("debug") || isShowLog){
            Log.v(MyPatchListener.TAG, message);
        }
    }
}
