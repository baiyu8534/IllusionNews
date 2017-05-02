package com.example.showapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.showapp.InfoActivity;
import com.example.showapp.R;
import com.example.showapp.adapter.TravelRecyclerAdapter;
import com.example.showapp.view.TravelRecyclerView;

/**
 * Created by baiyu on 2017/4/24.
 */
public class TestTraveRecyclerFragment extends Fragment {

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_travel_recycler, container, false);

        TravelRecyclerView trv = (TravelRecyclerView) view.findViewById(R.id.trv);

        TravelRecyclerAdapter travelRecyclerAdapter = new TravelRecyclerAdapter(imageres);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

        trv.setLayoutManager(linearLayoutManager);

        travelRecyclerAdapter.setListener(new TravelRecyclerAdapter.onItemClickListener() {
            @Override
            public void onClick(ImageView v,int resId) {


                startInfoActivity(v,resId);
            }
        });

        trv.setAdapter(travelRecyclerAdapter);


        return view;
    }

    private void startInfoActivity(View view,int resId) {
        Intent intent = new Intent(getContext(), InfoActivity.class);
        intent.putExtra("resId",resId);
        ActivityCompat.startActivity(getActivity(),
                intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        getActivity(),
                        new Pair<>(view, getString(R.string.transition_image)))
                        .toBundle());
    }
}
