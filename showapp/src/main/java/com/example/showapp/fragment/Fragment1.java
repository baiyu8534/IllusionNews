package com.example.showapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.showapp.R;
import com.example.showapp.adapter.DemosRvAdapter;
import com.example.showapp.bean.ShowDemoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baiyu on 2017/2/10.
 */
public class Fragment1 extends android.support.v4.app.Fragment{

    public SwipeRefreshLayout mSwipeRefreshLayout;
    public RecyclerView mRecyclerView;

    private List<ShowDemoBean> mShowDemoBeanList = new ArrayList<>();

    private ShowDemoBean[] mShowDemoBeens = {
            new ShowDemoBean("demo", R.drawable.deoms),
            new ShowDemoBean("demo", R.drawable.deoms),
            new ShowDemoBean("demo", R.drawable.deoms),
            new ShowDemoBean("demo", R.drawable.deoms),
            new ShowDemoBean("demo", R.drawable.deoms),
            new ShowDemoBean("demo", R.drawable.deoms),
            new ShowDemoBean("demo", R.drawable.deoms)
    };
    private DemosRvAdapter mRvAdapter;
    public Button mButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1,container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_show);

        initAdapterData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRvAdapter = new DemosRvAdapter(mShowDemoBeanList);
        mRecyclerView.setAdapter(mRvAdapter);

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mShowDemoBeanList.add(new ShowDemoBean("demo",R.drawable.deoms));
                                mRvAdapter.notifyDataSetChanged();
                                mSwipeRefreshLayout.setRefreshing(false);//隐藏刷新进度条
                            }
                        });
                    }
                }).start();
            }
        });

        return view;
    }

    private void initAdapterData() {
        for (ShowDemoBean showDemoBeen : mShowDemoBeens) {
            mShowDemoBeanList.add(showDemoBeen);
        }
    }
}
