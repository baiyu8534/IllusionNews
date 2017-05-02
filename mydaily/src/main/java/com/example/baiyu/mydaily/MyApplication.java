package com.example.baiyu.mydaily;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baiyu on 2017/4/22.
 */
public class MyApplication extends Application {

    private static MyApplication sMyApplication;
    private static int mainTid;

    private static List<BaseActivity> sActivityList;

    private static Activity currentActivity;

    public static int getMainTid(){return mainTid;}

    @Override
    public void onCreate() {
        super.onCreate();
        if(sMyApplication == null){
            sMyApplication = MyApplication.this;
        }

        sActivityList = new ArrayList<>();
        mainTid = android.os.Process.myTid();
    }

    public void addActivity(BaseActivity activity){sActivityList.add(activity);}

    public void removeActivity(BaseActivity activity){sActivityList.remove(activity);}

    public void finishAllActivity(){
        for (BaseActivity activity : sActivityList) {
            activity.finish();
        }
        sActivityList.clear();
    }

    public void exit(){
        finishAllActivity();
        System.exit(0);
    }

    public static Context getContext(){return sMyApplication;}

    public static MyApplication getMyApplication(){return sMyApplication;}

    public static List<BaseActivity> getActivityList() {
        return sActivityList;
    }
}
