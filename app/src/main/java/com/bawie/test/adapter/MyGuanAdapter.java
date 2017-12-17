package com.bawie.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.test.R;
import com.bawie.test.entity.FollowUsersBean;
import com.bawie.test.util.GlideCircleTransform;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 关注用户列表的适配器
 */

public class MyGuanAdapter extends RecyclerView.Adapter<MyGuanAdapter.MyGuanViewHolder>{

    private final Context context;
    private final List<FollowUsersBean.DataBean> data;

    public MyGuanAdapter(Context context, List<FollowUsersBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyGuanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.guan_list, null);

        MyGuanViewHolder holder = new MyGuanViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyGuanViewHolder holder, int position) {

        String icon = data.get(position).icon;
        String nickname = data.get(position).nickname;

        Glide.with(context).load(icon).bitmapTransform(new GlideCircleTransform(context)).into(holder.guan_list_touxiang);
        holder.guan_list_nicheng.setText(nickname);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyGuanViewHolder extends RecyclerView.ViewHolder{

        private final ImageView guan_list_touxiang;
        private final TextView guan_list_nicheng;
        private final ImageView guan_list_qu;

        public MyGuanViewHolder(View itemView) {
            super(itemView);
            guan_list_touxiang = itemView.findViewById(R.id.guan_list_touxiang);
            guan_list_nicheng = itemView.findViewById(R.id.guan_list_nicheng);
            guan_list_qu = itemView.findViewById(R.id.guan_list_qu);

        }
    }

}
