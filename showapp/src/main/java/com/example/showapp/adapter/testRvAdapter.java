package com.example.showapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.showapp.R;
import com.example.showapp.view.MyListView;

/**
 * Created by baiyu on 2017/2/9.
 */
public class testRvAdapter extends RecyclerView.Adapter<testRvAdapter.ViewHolder> {

    private Context mContext;

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
            R.drawable.g,

    };

    public testRvAdapter() {
        super();
    }

    @Override
    public testRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_dream_travel, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        MyAdapter adapter = new MyAdapter(imageres, mContext);
        holder.lv.setAdapter(adapter);
//        View viewHeader = View.inflate(getContext(), R.layout.listhander, null);
//        myListView.addHeaderView(viewHeader);
        holder.lv.setMyAdapter(adapter);

    }
    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        MyListView lv;

        public ViewHolder(View itemView) {
            super(itemView);
            lv = (MyListView) itemView.findViewById(R.id.lv);
        }
    }
}
