package com.example.showapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by baiyu on 2017/2/10.
 */
public class PartnerActivity extends AppCompatActivity {


    public static final String PARTNER_NAME = "partner_name";

    public static final String PARTNER_IMAGE_ID = "partner_image_id";

    public static final String PARTNER_PROFILE_ID = "partner_profile_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner);

        translucentStatusBar();

        Intent intent = getIntent();
        String partnerName = intent.getStringExtra(PARTNER_NAME); //海贼名称
        int partnerImageId = intent.getIntExtra(PARTNER_IMAGE_ID,R.drawable.deoms);//海贼图片id
        int partnerProfileId = intent.getIntExtra(PARTNER_PROFILE_ID,R.string.mingren);//海贼资料id

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView partnerImageView = (ImageView) findViewById(R.id.partner_image_view);
        TextView partnerProfile = (TextView) findViewById(R.id.partner_profile);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(partnerName); //设置标题
        Glide.with(this).load(partnerImageId).into(partnerImageView);//设置图片
        partnerProfile.setText(getString(partnerProfileId));//设置内容
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                // 返回上一个活动
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 状态栏着色
     */
    private void translucentStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }
}
