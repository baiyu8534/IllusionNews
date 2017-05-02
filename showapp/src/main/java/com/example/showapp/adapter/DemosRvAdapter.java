package com.example.showapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.showapp.PartnerActivity;
import com.example.showapp.R;
import com.example.showapp.bean.ShowDemoBean;

import java.util.List;

/**
 * Created by baiyu on 2017/2/9.
 */
public class DemosRvAdapter extends RecyclerView.Adapter<DemosRvAdapter.ViewHolder> {

    private List<ShowDemoBean> mList;

    private Context mContext;

    public DemosRvAdapter(List<ShowDemoBean> list) {
        mList = list;
    }

    @Override
    public DemosRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.demoTitle.setText(mList.get(position).getTitle()+(position+1));
//        holder.domeImage.setImageResource(mList.get(position).getImageId());
        Glide.with(mContext).load(mList.get(position).getImageId()).into(holder.demoImage);

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PartnerActivity.class);
                intent.putExtra(PartnerActivity.PARTNER_NAME,mList.get(position).getTitle()+(position+1));
                intent.putExtra(PartnerActivity.PARTNER_IMAGE_ID,mList.get(position).getImageId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView mCardView;
        TextView demoTitle;
        ImageView demoImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView;
            demoTitle = (TextView) itemView.findViewById(R.id.tv_title);
            demoImage = (ImageView) itemView.findViewById(R.id.iv_deom);
        }
    }
}
