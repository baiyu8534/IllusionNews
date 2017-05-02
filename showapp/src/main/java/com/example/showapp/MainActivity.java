package com.example.showapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.showapp.adapter.MyFragmentPagerAdapter;
import com.example.showapp.fragment.DreamTravelFragment;
import com.example.showapp.fragment.Fragment1;
import com.example.showapp.fragment.Fragment2;
import com.example.showapp.fragment.TestTraveRecyclerFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Toolbar mToolBar;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    public NavigationView mNavigationView;
    public FloatingActionButton mFloatingActionButton;
    public TabLayout mTabLayout;
    public ViewPager mViewPager;

    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewListener();
    }


    private void initViewListener() {
        mNavigationView.setCheckedItem(R.id.nav_call);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                Toast.makeText(MainActivity.this, "点击了" + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了悬浮按钮", Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if (!mDrawerLayout.isDrawerOpen(mNavigationView)) {
        switch (item.getItemId()) {
            case R.id.delete:
                Snackbar.make(mFloatingActionButton, "删除数据", Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "已删除", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

                break;
            case R.id.setting:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.upload:
                Toast.makeText(this, "上传", Toast.LENGTH_SHORT).show();
                break;

        }
//        }
        return true;
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mTabLayout = (TabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);


//        下面就来解释一下TabGravity和TabMode，
//        TabGravity:放置Tab的Gravity,有GRAVITY_CENTER 和 GRAVITY_FILL两种效果。
//        顾名思义，一个是居中，另一个是尽可能的填充（注意，GRAVITY_FILL需要和MODE_FIXED一起使用才有效果）
//        TabMode:布局中Tab的行为模式（behavior mode），有两种值：MODE_FIXED 和 MODE_SCROLLABLE。
//        MODE_FIXED:固定tabs，并同时显示所有的tabs。
//        MODE_SCROLLABLE：可滚动tabs，显示一部分tabs，在这个模式下能包含长标签和大量的tabs，最好用于用户不需要直接比较tabs。
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setTabTextColors(R.color.colorPrimaryDark,R.color.colorPrimary);
//        mTabLayout.setTabTextColors(R.color.colorPrimary);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimaryDark));

        mFragmentList.add(new Fragment1());
        mFragmentList.add(new DreamTravelFragment());
        mFragmentList.add(new TestTraveRecyclerFragment());
        mFragmentList.add(new Fragment2());
        mFragmentList.add(new Fragment2());
        mFragmentList.add(new Fragment2());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), this,
                mFragmentList);

        mViewPager.setAdapter(myFragmentPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);


        setSupportActionBar(mToolBar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //设置那个矢量动画按钮
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, 0, 0);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

//        WaveBackGroundVIew wbg = (WaveBackGroundVIew) mNavigationView.getRootView().findViewById(R.id.wbg);
        View headerLayout =
                mNavigationView.inflateHeaderView(R.layout.nav_hander_layout);

        ImageView iconImage = (ImageView) headerLayout.findViewById(R.id.icon_image);
        iconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "asdf", Toast.LENGTH_SHORT).show();
            }
        });

//        WaveBackGroundVIew wbg = (WaveBackGroundVIew) headerLayout.findViewById(R.id.wbg);
////        TitanicTextView ttv = (TitanicTextView) headerLayout.findViewById(R.id.ttv);
//        Titanic titanic = new Titanic();
//        titanic.startView(wbg);
    }
}
