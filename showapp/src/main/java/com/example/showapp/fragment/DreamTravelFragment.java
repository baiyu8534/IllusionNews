package com.example.showapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.showapp.R;
import com.example.showapp.adapter.MyAdapter;
import com.example.showapp.view.MyListView;

/**
 * Created by baiyu on 2017/2/10.
 */
public class DreamTravelFragment extends Fragment {

    private int[] imageres = new int[]{
            R.drawable.a,
            R.drawable.d,
            R.drawable.f,
            R.drawable.g,R.drawable.a,
            R.drawable.d,
            R.drawable.f,
            R.drawable.g,R.drawable.a,
            R.drawable.d,
            R.drawable.f,
            R.drawable.g
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dream_travel, container, false);

        MyListView myListView = (MyListView) view.findViewById(R.id.lv);

        MyAdapter adapter = new MyAdapter(imageres, getContext());
        myListView.setAdapter(adapter);
//        View viewHeader = View.inflate(getContext(), R.layout.listhander, null);
//        myListView.addHeaderView(viewHeader);
        myListView.setMyAdapter(adapter);

//        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv_test);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
//        rv.setLayoutManager(gridLayoutManager);
//
//        testRvAdapter testRvAdapter = new testRvAdapter();
//        rv.setAdapter(testRvAdapter);

        return view;
    }
}
