package com.bawie.test.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.test.R;
import com.bawie.test.entity.VideosBean;
import com.bawie.test.util.GlideCircleTransform;
import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 *主页面的XrecyclerView的适配器
 */

public class MyZhuAdapter extends XRecyclerView.Adapter<MyZhuAdapter.MyZhuViewHolder> implements View.OnClickListener {


    private final Context context;
    private final List<VideosBean.DataBean> data;


    public MyZhuAdapter(Context context, List<VideosBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyZhuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.zhu_list,null);
        MyZhuViewHolder holder = new MyZhuViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyZhuViewHolder holder, int position) {

        String icon = data.get(position).user.icon;
        String nickname = data.get(position).user.nickname;
        String createTime = data.get(position).createTime;
        String workDesc = data.get(position).workDesc;
        String videoUrl = data.get(position).videoUrl;
        final String cover = data.get(position).cover;//封面

        //圆形头像
        Glide.with(context).load(icon)
                .bitmapTransform(new GlideCircleTransform(context))
                .into(holder.zhu_list_touxiang);
        holder.zhu_list_nicheng.setText(nickname);
        holder.zhu_list_data.setText(createTime);
        holder.zhu_list_des.setText(workDesc);

        View player = View.inflate(context, R.layout.simple_player_view_player, holder.zhu_list_player);
        String replace = videoUrl.replace("https://www.zhaoapi.cn","http://120.27.23.105");

        PlayerView playerView = new PlayerView((Activity) context,player)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(replace)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        //视频加载之前显示缩略图
                        Glide.with(context).load(cover).into(ivThumbnail);
                    }
                })
                .startPlay();

        holder.zhu_list_guan.setOnClickListener(this);
        holder.zhu_list_cang.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zhu_list_cang:
                Toast.makeText(context, "点击了收藏", Toast.LENGTH_SHORT).show();



                break;

            case R.id.zhu_list_guan:
                Toast.makeText(context, "点击了关注", Toast.LENGTH_SHORT).show();



                break;
        }
    }

    class MyZhuViewHolder extends XRecyclerView.ViewHolder{

        private final ImageView zhu_list_touxiang;
        private final TextView zhu_list_nicheng;
        private final TextView zhu_list_data;
        private final TextView zhu_list_des;
        private final RelativeLayout zhu_list_player;
        private final Button zhu_list_cang;
        private final Button zhu_list_guan;

        public MyZhuViewHolder(View itemView) {
            super(itemView);
            zhu_list_touxiang = itemView.findViewById(R.id.zhu_list_touxiang);
            zhu_list_nicheng = itemView.findViewById(R.id.zhu_list_nicheng);
            zhu_list_data = itemView.findViewById(R.id.zhu_list_data);
            zhu_list_des = itemView.findViewById(R.id.zhu_list_des);
            zhu_list_player = itemView.findViewById(R.id.zhu_list_player);
            //关注收藏
            zhu_list_cang = itemView.findViewById(R.id.zhu_list_cang);
            zhu_list_guan = itemView.findViewById(R.id.zhu_list_guan);

        }
    }

}
