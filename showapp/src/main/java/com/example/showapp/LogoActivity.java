package com.example.showapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.showapp.view.Titanic;
import com.example.showapp.view.TitanicTextView;
import com.example.showapp.view.Typefaces;

/**
 * Created by baiyu on 2017/2/12.
 */
public class LogoActivity extends AppCompatActivity {

    public TitanicTextView mTitanicTextView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        mTitanicTextView = (TitanicTextView) findViewById(R.id.titanic_tv);
        mTitanicTextView.setTypeface(Typefaces.get(this, "Satisfy-Regular.ttf"));

        // start animation
        final Titanic titanic = new Titanic();
        titanic.start(mTitanicTextView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoActivity.this, MainActivity.class);
                LogoActivity.this.startActivity(intent);
                LogoActivity.this.finish();
            }
        },3000);


    }
}
