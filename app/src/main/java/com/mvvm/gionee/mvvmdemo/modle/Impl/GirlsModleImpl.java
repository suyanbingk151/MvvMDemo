package com.mvvm.gionee.mvvmdemo.modle.Impl;

import com.mvvm.gionee.mvvmdemo.data.GirlsData;
import com.mvvm.gionee.mvvmdemo.modle.GirlsModle;
import com.mvvm.gionee.mvvmdemo.net.NetManager;

import java.util.Map;

import io.reactivex.Observable;
import com.mvvm.gionee.mvvmdemo.service.GirlsService;

/**
 * Created by sulc on 2018/1/17.
 */

public class GirlsModleImpl implements GirlsModle {

    @Override
    public Observable<GirlsData> getGirlsListData(Map<String, String> map) {
        GirlsService girlsService = NetManager.getInstance().create(GirlsService.class);
        return girlsService.getGirlsListData(map);
    }
}
