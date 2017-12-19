package com.bawie.test.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bawie.test.R;
import com.bawie.test.entity.UserVideosBean;
import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;

import java.util.List;

/**
 * 上传作品的adapter类
 */

public class UplocadAdapter extends RecyclerView.Adapter<UplocadAdapter.UpViewHolder>{

    private final Context context;
    private final List<UserVideosBean.DataBean> data;

    public UplocadAdapter(Context context, List<UserVideosBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public UpViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.img_rv_list, null);
        UpViewHolder holder = new UpViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(UpViewHolder holder, int position) {

        final String cover = data.get(position).cover;
        String videoUrl = data.get(position).videoUrl;


        View player = View.inflate(context, R.layout.simple_player_view_player, holder.img_rv_list);
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

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class UpViewHolder extends RecyclerView.ViewHolder{

        private final RelativeLayout img_rv_list;

        public UpViewHolder(View itemView) {
            super(itemView);
            img_rv_list = itemView.findViewById(R.id.img_rv_list);
        }
    }

}
