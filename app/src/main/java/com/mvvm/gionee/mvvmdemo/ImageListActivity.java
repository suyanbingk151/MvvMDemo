package com.mvvm.gionee.mvvmdemo;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.mvvm.gionee.mvvmdemo.adapter.GirlsAdapter;
import com.mvvm.gionee.mvvmdemo.data.GirlsData;
import com.mvvm.gionee.mvvmdemo.databinding.ActivityImagelistBinding;
import com.mvvm.gionee.mvvmdemo.interfacemv.GirlItemClickCallback;
import com.mvvm.gionee.mvvmdemo.view.XRecyclerViewBaseView;
import com.mvvm.gionee.mvvmdemo.viewmodle.GirlsViewModel;

/**
 * Created by sulc on 2018/1/16.
 */

public class ImageListActivity extends AppCompatActivity implements XRecyclerView.LoadingListener,XRecyclerViewBaseView,GirlItemClickCallback {

    GirlsViewModel girlsViewModel;
    ActivityImagelistBinding binding;
    GirlsAdapter girlsAdapter;
    int page = 1;
    int pagesize = 5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_imagelist);
        initRecyclerView();

        girlsViewModel = new GirlsViewModel(ImageListActivity.this.getApplication(),this);
        girlsAdapter = new GirlsAdapter(this);
        binding.setRecyclerAdapter(girlsAdapter);
        girlsViewModel.loadGirlListData(page,pagesize);
        subscribeToModel(girlsViewModel);
    }


    private void initRecyclerView() {
        binding.newsRv.setRefreshProgressStyle(ProgressStyle.BallClipRotate); //设置下拉刷新的样式
        binding.newsRv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate); //设置上拉加载更多的样式
        binding.newsRv.setArrowImageView(R.mipmap.pull_down_arrow);
        binding.newsRv.setLoadingListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.newsRv.setLayoutManager(layoutManager);
    }

    private void subscribeToModel(final GirlsViewModel model){
        model.getLiveObservableData().observe(this, new Observer<GirlsData>() {
            @Override
            public void onChanged(@Nullable GirlsData girlsData) {
                girlsAdapter.setGirlsList(girlsData.getData());
            }
        });
    }

    @Override
    public void onRefresh() {
        girlsViewModel.clearListData();
        page =1;
        girlsViewModel.loadGirlListData(page,pagesize);
    }

    @Override
    public void onLoadMore() {
        page= page + pagesize;
        girlsViewModel.loadGirlListData(page,pagesize);
    }

    @Override
    public void loadFailure(String message) {
        binding.newsRv.loadMoreComplete(); //结束加载
        binding.newsRv.refreshComplete(); //结束刷新
    }

    @Override
    public void loadStart(int loadType) {

    }

    @Override
    public void loadComplete() {
        binding.newsRv.loadMoreComplete(); //结束加载
        binding.newsRv.refreshComplete(); //结束刷新
    }

    @Override
    public void onClick(GirlsData.ResultsBean girlsItem) {

    }
}
