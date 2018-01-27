package com.mvvm.gionee.mvvmdemo.view;

/**
 * Created by sulc on 2018/1/17.
 */

public interface XRecyclerViewBaseView extends IBaseView{

    /**
     * 开始加载
     *
     * @param loadType 加载的类型 0：第一次记载 1：下拉刷新 2：上拉加载更多
     */
    void loadStart(int loadType);
    /**
     * 加载完成
     */
    void loadComplete();

}
