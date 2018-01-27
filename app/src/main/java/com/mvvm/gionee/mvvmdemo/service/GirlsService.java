package com.mvvm.gionee.mvvmdemo.service;

import com.mvvm.gionee.mvvmdemo.data.GirlsData;
import com.mvvm.gionee.mvvmdemo.utils.ApiUtils;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;


/**
 * Created by sulc on 2018/1/17.
 */

public interface GirlsService {
    String BASE_URL = ApiUtils.girlsUrl;

    @POST("channel/listjson")
    Observable<GirlsData> getGirlsListData(@QueryMap Map<String, String> map);
}
