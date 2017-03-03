package com.laowu.studypro;

import android.app.Application;
import android.util.Log;

import com.laowu.studypro.utils.NotificationUtils;

/**
 * Created by LaoWu on 2017/3/2.
 */

public class Appcontext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if(NotificationUtils.isNotificationEnabled(getApplicationContext())) {
            logMsg("有弹窗权限");
        } else {
            logMsg("无弹窗权限");
        }
    }

    private void logMsg(String msg) {
        Log.i("liu", msg);
    }
}
