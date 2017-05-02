package com.example.baiyu.mydaily;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.baiyu.mydaily.utils.ConstantUtility;

import java.lang.ref.WeakReference;

/**
 * Created by baiyu on 2017/4/22.
 */
public class BaseActivity extends AppCompatActivity {

    public BaseHandler mBaseHandler;
    public SimpleSyncMsg mSimpleSyncMsg;
    public SimpleUiMsg mSimpleUiMsg;
    public ProgressMsg mProgressMsg;

    public ProgressDialog mProgressDialog;

    public static class BaseHandler extends Handler {
        private WeakReference<BaseActivity> activityWeakReference;

        public BaseHandler(BaseActivity activity) {
            activityWeakReference = new WeakReference<BaseActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            BaseActivity activity = activityWeakReference.get();
            if (activity != null) {
                switch (msg.what){
                    case ConstantUtility.SIMPLE_UI_MESSAGE:
                        if(activity.mSimpleUiMsg!=null) activity.mSimpleUiMsg.onReceiveMsg(msg);
                        break;
                    case ConstantUtility.SIMPLE_SYNC_MESSAGE:
                        if(activity.mSimpleSyncMsg!=null) activity.mSimpleSyncMsg.onReceiveMsg(msg);
                        break;
                    case ConstantUtility.SHOW_PROGRESS_MESSAGE:
                        if(activity.mSimpleSyncMsg!=null)
                            activity.mProgressMsg.showProgress();
                        else
                            activity.showProgress();
                        break;
                    case ConstantUtility.DISMISS_PROGRESS_MESSAGE:
                        if(activity.mSimpleSyncMsg!=null)
                            activity.mProgressMsg.dismissProgress();
                        else
                            activity.dismissProgress();
                        break;
                }
            }
        }
    }

    public interface SimpleUiMsg{
        void onReceiveMsg(Message msg);
    }
    public interface SimpleSyncMsg{
        void onReceiveMsg(Message msg);
    }
    public interface  ProgressMsg{
        void showProgress();
        void dismissProgress();
    }

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mBaseHandler = new BaseHandler(this);
//        System.out.println(((MyApplication)MyApplication.getApplication()));
//        ((MyApplication)MyApplication.getApplication()).addActivity(this);
//        initDialog();
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseHandler = new BaseHandler(this);
        System.out.println(MyApplication.getMyApplication());
        MyApplication.getMyApplication().addActivity(this);
        initDialog();
    }

    private void initDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
    }

    public void showProgress(){
        if(mProgressDialog!=null&&!mProgressDialog.isShowing()){
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.dialog);
        }
    }

    public void dismissProgress(){
        if(mProgressDialog!=null&&mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getMyApplication().removeActivity(this);
    }
}
