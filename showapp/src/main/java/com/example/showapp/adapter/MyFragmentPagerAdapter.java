package com.example.showapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by baiyu on 2017/2/10.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<Fragment> mList;
    private String[] titles = {"Tab1","Tab2","Tab3","Tab4","Tab5","Tab6",};

    public MyFragmentPagerAdapter(FragmentManager fm, Context context, List<Fragment> list) {
        super(fm);
        mContext = context;
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
