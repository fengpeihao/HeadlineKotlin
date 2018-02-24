package com.fph.headlinekotlin.hotfix;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.multidex.MultiDex;

import com.fph.headlinekotlin.BuildConfig;
import com.fph.headlinekotlin.hotfix.log.MyLogImp;
import com.fph.headlinekotlin.hotfix.utils.ApplicationContext;
import com.fph.headlinekotlin.hotfix.utils.TinkerManager;
import com.fph.headlinekotlin.utils.AndroidUtils;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;

import cn.jpush.android.api.JPushInterface;


/**
 * Created by admin on 2017/6/8.
 */

public class ApplicationDelegate extends DefaultApplicationLike {

    private static final String TAG = "Tinker.ApplicationDelegate";
    private static ApplicationDelegate sInstance;

//    private Set<Activity> allActivities;

    public ApplicationDelegate(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag,
                               long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    /**
     * install multiDex before install tinker
     * so we don't need to put the tinker lib classes in the main dex
     *
     * @param base
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //you must install multiDex whatever tinker is installed!
        sInstance=this;
        MultiDex.install(base);
        ApplicationContext.application = getApplication();
        ApplicationContext.context = getApplication();
        TinkerManager.setTinkerApplicationLike(this);

        TinkerManager.initFastCrashProtect();
        //should set before tinker is installed
        TinkerManager.setUpgradeRetryEnable(true);

        //optional set logIml, or you can use default debug log
        TinkerInstaller.setLogIml(new MyLogImp());

        //installTinker after load multiDex
        //or you can put com.tencent.tinker.** to main dex
        TinkerManager.installTinker(this);
        Tinker tinker = Tinker.with(getApplication());
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        getApplication().registerActivityLifecycleCallbacks(callback);
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        PlatformConfig.setWeixin("wx699d72ae95a85e87", "a626af227341260d66ca277fa8f29bad");
//        PlatformConfig.setQQZone("1106147169", "cxJpoIbBGt88S9aO");
//        PlatformConfig.setSinaWeibo("2480041639", "fc45c092d152a6382b0d84d1868a5d21","");
//        Bugly.init(getApplication(), "8b964ad433", false);

//        UMShareAPI.get(getApplication());

        //Config.DEBUG = true;


//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(getApplicationContext());
        //初始化sdk
        JPushInterface.setDebugMode(BuildConfig.DEBUG);//正式版的时候设置false，关闭调试
        JPushInterface.init(getApplication());
        JPushInterface.setAlias(getApplication(), AndroidUtils.INSTANCE.getIme(), null);
    }
}
