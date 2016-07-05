package com.qtfreet.beautyleg.ui;

import android.app.Activity;
import android.app.Application;
import android.widget.Toast;

import com.liulishuo.filedownloader.FileDownloader;
import com.qtfreet.beautyleg.R;
import com.qtfreet.beautyleg.utils.Utils;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by qtfreet00 on 2016/3/3.
 */
public class App extends Application {
    private List<Activity> activityList = new LinkedList<>();
    private static App instance;
    public static App getInstance() {
        if (null == instance) {
            synchronized (App.class){
                instance = new App();
            }
        }
        return instance;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    // 遍历所有Activity并finish
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        FileDownloader.init(getApplicationContext());
        FileDownloader.setGlobalPost2UIInterval(1000);
        if (!Utils.isWifi(this)) {
            Toast.makeText(this, R.string.nowifi, Toast.LENGTH_SHORT).show();
        }
    }
}
