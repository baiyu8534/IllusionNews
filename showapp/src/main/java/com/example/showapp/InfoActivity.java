package com.example.showapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by baiyu on 2017/4/24.
 */
public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        int resId = getIntent().getIntExtra("resId", R.drawable.hander);
        ImageView imageView = (ImageView) findViewById(R.id.iv_info);
        //imageView.setImageResource(resId);
        Glide.with(this).load(resId).into(imageView);

        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
