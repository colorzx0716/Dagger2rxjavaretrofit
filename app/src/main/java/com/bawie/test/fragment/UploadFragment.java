package com.bawie.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawie.test.DaggerVideoComponent;
import com.bawie.test.R;
import com.bawie.test.VideoComponent;
import com.bawie.test.VideoModule;
import com.bawie.test.adapter.UplocadAdapter;
import com.bawie.test.entity.UserVideosBean;
import com.bawie.test.presenter.UserVideosPresenter;
import com.bawie.test.util.ShareprefrensUtils;
import com.bawie.test.view.UserVideosView;

import java.util.List;

import javax.inject.Inject;

/**
 * 我的作品，上传的视频Fragment
 */

public class UploadFragment extends Fragment implements UserVideosView{

    private View view;
    private RecyclerView upload_rv;

    //注入对象
    @Inject
    UserVideosPresenter userVideosPresenter;
    private String uid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //注入
        VideoComponent component = DaggerVideoComponent.builder().videoModule(new VideoModule(this)).build();
        component.inject(this);

        view = View.inflate(getActivity(), R.layout.upload_fragment, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        upload_rv = view.findViewById(R.id.upload_rv);

        uid = (String) ShareprefrensUtils.get(getActivity(), "uid", "");
        userVideosPresenter.getUserData(uid +"","1");

    }

    @Override
    public void UserVideosSuccess(UserVideosBean value) {

        List<UserVideosBean.DataBean> data = value.data;

        upload_rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        UplocadAdapter adapter = new UplocadAdapter(getActivity(),data);
        upload_rv.setAdapter(adapter);
    }

    @Override
    public void UserVideosFailure(String msg) {

    }
}
