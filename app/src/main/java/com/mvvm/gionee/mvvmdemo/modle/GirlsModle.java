package com.mvvm.gionee.mvvmdemo.modle;

import com.mvvm.gionee.mvvmdemo.data.GirlsData;
import java.util.Map;
import io.reactivex.Observable;


/**
 * Created by sulc on 2018/1/17.
 */

public interface GirlsModle {

    Observable<GirlsData> getGirlsListData(Map<String, String> map);
}
